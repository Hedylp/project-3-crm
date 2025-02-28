<template>
  <div>
    <a-card>
      <div>
        <a-space class="operator">
          <a-form layout="inline" :form="queryForm">
            <a-form-item label="关键字">
              <a-input
                  v-decorator="['keyword', { rules: [{ required: false,min:1,max:120,message:'输入长度应在1到120之间'}] }]"
                  placeholder="请输入姓名/邮箱"
              />
            </a-form-item>
            <a-form-item>
              <a-button @click="query()" :loading="queryLoading">查询</a-button>
            </a-form-item>
          </a-form>
          <a-button type="primary" @click="showModal('添加')">添加数据字典</a-button>
        </a-space>
        <a-table
            :columns="columns"
            :data-source="dataSource"
            :pagination="pagination"
            :loading="loading"
            @change="handleTableChange"
        >
           <span slot="action" slot-scope="text">
              <a @click="updateItem(text.id)">编辑</a>
           </span>
        </a-table>
      </div>
    </a-card>
    <a-modal
        :title="title"
        :visible="visible"
        :confirm-loading="confirmLoading"
        @ok="handleOk"
        @cancel="handleCancel"
        okText="提交"
    >
      <a-form :form="form" :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }">
        <a-form-item hidden>
          <a-input v-decorator="['id',{ rules: [{ required: false}] }]"/>
        </a-form-item>
        <a-form-item label="数据字典名称">
          <a-input
              v-decorator="['title', { rules: [{ required: true,min:1,max:15,message:'内容长度在1到15之间' }] }]"
          />
        </a-form-item>
        <a-form-item label="数据字典编号">
          <a-input
              v-decorator="['sn',{ rules: [{ required: true, validator:validators.length({min:1,max:50}) }] },]"
              placeholder="请输入数据字典编号"
          />
        </a-form-item>
        <a-form-item label="数据字典简介">
          <a-input
              v-decorator="['intro',{ rules: [{ required: true, min:3,max:100,message:'内容长度在3到100之间' }] },]"
              placeholder="请输入数据字典简介"
          />
        </a-form-item>
      </a-form>
    </a-modal>
  </div>
</template>

<script>
import * as dictionaryContents from "@/services/dictionaryContents"
import validators from "@/utils/validators";
const columns = [
  {
    title: '编号',
    dataIndex: 'id'
  },
  {
    title: '名称',
    dataIndex: 'title',
    ellipsis: true,
  },
  {
    title: '编码',
    dataIndex: 'sn',
    ellipsis: true,
  },
  {
    title: '简介',
    dataIndex: 'intro',
    ellipsis: true,
  },
  {
    title: '操作',
    scopedSlots: {customRender: 'action'}
  }
]
export default {
  data() {
    return {
      validators,
      queryForm:this.$form.createForm(this, {name: 'coordinated'}),
      queryLoading:false,
      // table
      columns: columns,
      dataSource: [],
      selectedRows: [],
      pagination: {},
      loading: false,
      // modal
      title: '添加',
      visible: false,
      confirmLoading: false,
      // modal form
      form: this.$form.createForm(this, {name: 'coordinated'}),
    }
  },
  created() {
    this.fetch()
  },
  methods: {
    query(){
      this.queryLoading = true
      this.queryForm.validateFields((err, values) => {
        if (err) {
          this.queryLoading = false
          console.log("form error");
          return;
        }
        this.fetch({"page": this.pagination.current, "size": 10,...values})
      })
    },
    // table
    handleTableChange(pagination) {
      const pager = {...this.pagination};
      pager.current = pagination.current;
      this.pagination = pager;
      this.fetch({
        size: pagination.pageSize,
        page: pagination.current,
      });
    },
    fetch(params = {"page": 1, "size": 10}) {
      this.loading = true
      dictionaryContents.list(params || {"page": 1, "size": 10}).then(({data}) => {
        const res = data.data
        const pagination = {...this.pagination};
        pagination.total = res.total
        pagination.current = params.page
        this.dataSource = res.list.map((e, i) => ({key: i + "",...e}))
        this.pagination = pagination
        this.loading = false
        this.queryLoading = false
      })
    },
    deleteItem(text) {
      const title = '删除'
      dictionaryContents.deleteItem(text.id).then(({data})=>{
        if (data.code !== 200) {
          this.$notification['error']({
            message: title + '数据字典信息出现错误',
            description: '建议检查网络连接或重新登陆',
          });
        }
        this.$notification.success({
          message: title + '成功',
          description: title + '数据字典信息成功',
        });
        this.fetch({"page": this.pagination.current, "size": 10})
      })
    },
    updateItem(id) {
      this.showModal('更改')
      dictionaryContents.getDetail(id).then(({data}) => {
        // 这里不能循环
        this.form.setFieldsValue({"id": data.data["id"]})
        this.form.setFieldsValue({"sn": data.data["sn"]})
        this.form.setFieldsValue({"title": data.data["title"]})
        this.form.setFieldsValue({"intro": data.data["intro"]})
      })
    },
    // modal
    showModal(title = '添加') {
      this.visible = true;
      this.title = title || '添加'
      this.form.resetFields()
    },
    handleOk() {
      this.confirmLoading = true;
      this.form.validateFields((err, values) => {
        if (err) {
          this.confirmLoading = true;
          console.log("form error");
          return;
        }
        let method = 'add';
        if (values.id) method = 'update';

        dictionaryContents[method](values).then(({data}) => {
          this.confirmLoading = false;
          if (data.code !== 200) {
            this.$notification['error']({
              message: this.title + '数据字典信息出现错误',
              description: '建议检查网络连接或重新登陆',
            });
          }else{
            this.$notification.success({
              message: this.title + '成功',
              description: this.title + '数据字典信息成功',
            });
          }
          this.visible = false
          this.query()
        })
      });
    },
    handleCancel() {
      this.visible = false;
      this.title=''
      this.confirmLoading = false
      this.form.resetFields()
    }
  }
}
</script>

<style lang="less" scoped>
.search {
  margin-bottom: 54px;
}

.fold {
  width: calc(100% - 216px);
  display: inline-block
}

.operator {
  margin-bottom: 18px;
}

@media screen and (max-width: 900px) {
  .fold {
    width: 100%;
  }
}
</style>
