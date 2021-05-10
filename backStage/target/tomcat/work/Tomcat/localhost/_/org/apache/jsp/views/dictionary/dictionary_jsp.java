/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2021-05-10 08:27:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.dictionary;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dictionary_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("          \r\n");
      out.write("<hr class=\"layui-bg-orange\">\r\n");
      out.write("\r\n");
      out.write("<!-- 搜索框 -->\r\n");
      out.write("<form class=\"layui-form\">\r\n");
      out.write("\t\t<blockquote class=\"layui-elem-quote quoteBox\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"layui-input \" name=\"name\"  placeholder=\"请输入搜索的内容\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"layui-btn\" data-type=\"reload\" id=\"searchButton\">搜索</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</blockquote>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<!-- 要显示的表格 id是必须的 -->\r\n");
      out.write("<table class=\"layui-hide\" id= \"dictionary-table\" lay-filter=\"dictionary-table\">\r\n");
      out.write("</table>        \r\n");
      out.write("\r\n");
      out.write("<script type=\"text/html\" id=\"table-bar\">\r\n");
      out.write("  <a class=\"layui-btn layui-btn-xs\" lay-event=\"detail\">查看子项</a>\r\n");
      out.write("  <a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\">编辑</a>\r\n");
      out.write("  <a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\">删除</a>\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script >\r\n");
      out.write("layui.use(['table','element'], function(){\r\n");
      out.write("    $ = layui.jquery;\r\n");
      out.write("    var table = layui.table;\r\n");
      out.write("    var layer = layui.layer;\r\n");
      out.write("    var element = layui.element;\r\n");
      out.write("\r\n");
      out.write("  //加载表格数据\r\n");
      out.write("  var tableload = layer.load(2);\r\n");
      out.write("  table.render({\r\n");
      out.write("    elem: '#dictionary-table'       //html中表格的id\r\n");
      out.write("    ,even: true\t\t\t\t\t\t//开启隔行变色\r\n");
      out.write("    ,url: 'dictionary/admin/list' //数据接口\r\n");
      out.write("    ,method : 'post'\r\n");
      out.write("    ,page: true //开启分页\r\n");
      out.write("    ,cols: [[ //表头\r\n");
      out.write("        {type:'checkbox'}\r\n");
      out.write("      ,{field: 'id', title: 'ID',align:'center', width:100, sort: true, }//fixed: 'left'\r\n");
      out.write("      ,{field:'name', title: '字典名称'}\r\n");
      out.write("      ,{fixed: 'right', align:'center',width:200, toolbar: '#table-bar'}\r\n");
      out.write("    ]],\r\n");
      out.write("    done: function(){\r\n");
      out.write("    \tlayer.close(tableload);\r\n");
      out.write("    }\r\n");
      out.write("  });\r\n");
      out.write("    \r\n");
      out.write("  //监听数据操作按钮\r\n");
      out.write("  table.on('tool(dictionary-table)', function(obj){\r\n");
      out.write("        var data = obj.data;\r\n");
      out.write("        if(obj.event === 'detail'){\r\n");
      out.write("          \tseeDictionaryItem(data);\r\n");
      out.write("        } else if(obj.event === 'del'){\r\n");
      out.write("          layer.confirm('真的删除该字典吗?', function(index){\r\n");
      out.write("        \t  layer.close(index);\r\n");
      out.write("        \t  deleteData(data.id); \r\n");
      out.write("          });\r\n");
      out.write("        } else if(obj.event === 'edit'){\r\n");
      out.write("        \t//显示表单\r\n");
      out.write("            showForm('更新字典',data.id);\r\n");
      out.write("        }\r\n");
      out.write("      });\r\n");
      out.write("  \r\n");
      out.write("  //删除操作\r\n");
      out.write("  function deleteData(id){\r\n");
      out.write("\t  var index = 0;\r\n");
      out.write("\t  $.ajax({\r\n");
      out.write("          type: \"POST\",\r\n");
      out.write("          url: 'dictionary/admin/delete',\r\n");
      out.write("          data: {\"id\":id},\r\n");
      out.write("          dataType: \"json\",\r\n");
      out.write("          //请求前执行\r\n");
      out.write("          beforeSend:function(){\r\n");
      out.write("              load = layer.load(2);//显示加载动画\r\n");
      out.write("          },\r\n");
      out.write("          complete:function(){//请求完成执行，无论请求是否成功\r\n");
      out.write("              layer.close(load);//关闭加载动画\r\n");
      out.write("          },\r\n");
      out.write("          success: function(data){\r\n");
      out.write("              layer.msg(data.msg);\r\n");
      out.write("              if(data.success){//成功\r\n");
      out.write("                  //执行重载\r\n");
      out.write("                  table.reload('dictionary-table', {\r\n");
      out.write("                    page: {\r\n");
      out.write("                      curr: 1 //重新从第 1 页开始\r\n");
      out.write("                    }\r\n");
      out.write("                  });\r\n");
      out.write("              }\r\n");
      out.write("          },\r\n");
      out.write("          error:function(){\r\n");
      out.write("              layer.msg(\"服务器开小差了，请稍后再试...\");\r\n");
      out.write("          }\r\n");
      out.write("          \r\n");
      out.write("      });\r\n");
      out.write("  }\r\n");
      out.write("  \r\n");
      out.write("  //批量删除\r\n");
      out.write("  $('#delete-button').click(function(){\r\n");
      out.write("\t  \r\n");
      out.write("\t  var checkStatus = table.checkStatus('dictionary-table')\r\n");
      out.write("      ,data = checkStatus.data;\r\n");
      out.write("      if(data.length <= 0){\r\n");
      out.write("          layer.msg('请至少选择一行数据');\r\n");
      out.write("          return;\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      var showStr = '你确定删除以下字典吗？<br>';\r\n");
      out.write("      layui.each(data,function(index,item){\r\n");
      out.write("          showStr += item.name + '<br>';\r\n");
      out.write("      });\r\n");
      out.write("      \r\n");
      out.write("      layer.confirm(showStr,{icon:7, title:'确认删除'},function(index){\r\n");
      out.write("          layer.close(index);\r\n");
      out.write("          \r\n");
      out.write("          var su = 0;\r\n");
      out.write("          var fail = 0;\r\n");
      out.write("          var len = data.length;\r\n");
      out.write("          for(var i=0;i<data.length;i++){\r\n");
      out.write("        \t    \r\n");
      out.write("        \t  $.ajax({\r\n");
      out.write("                  type: \"POST\",\r\n");
      out.write("                  url: 'dictionary/admin/delete',\r\n");
      out.write("                  data: {\"id\":data[i].id},\r\n");
      out.write("                  dataType: \"json\",\r\n");
      out.write("                  success: function(data){\r\n");
      out.write("                \t  var p = (i + 1)/len * 100;\r\n");
      out.write("                \t  element.progress('demo', p + '%');\r\n");
      out.write("                \t  if(data.success){\r\n");
      out.write("                \t\t  su ++;\r\n");
      out.write("                \t  }else{\r\n");
      out.write("                \t\t  fail ++;\r\n");
      out.write("                \t  }              \t  \r\n");
      out.write("                  },\r\n");
      out.write("                  error:function(){\r\n");
      out.write("                      layer.msg(\"服务器开小差了，请稍后再试...\");\r\n");
      out.write("                  } \r\n");
      out.write("              }); \r\n");
      out.write("        \t  \r\n");
      out.write("          }  \r\n");
      out.write("          })\r\n");
      out.write("      });\r\n");
      out.write("\t  \r\n");
      out.write("\r\n");
      out.write("  //搜索功能\r\n");
      out.write("  $('#searchButton').on('click', function(){\r\n");
      out.write("      //执行重载\r\n");
      out.write("      table.reload('dictionary-table', {\r\n");
      out.write("        page: {\r\n");
      out.write("          curr: 1 //重新从第 1 页开始\r\n");
      out.write("        }\r\n");
      out.write("        ,where: {\r\n");
      out.write("            name: $('input[name=name]').val()\r\n");
      out.write("        }\r\n");
      out.write("      });\r\n");
      out.write("     \r\n");
      out.write("\t});\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  //查看字典子项\r\n");
      out.write("  function seeDictionaryItem(data){\r\n");
      out.write("\t  var window = layer.open({\r\n");
      out.write("\t\t  type: 2,\r\n");
      out.write("\t\t  title: '字典子项',\r\n");
      out.write("\t\t  area:['50%','80%'],\r\n");
      out.write("\t\t  closeBtn: 1,\r\n");
      out.write("\t\t  //area: '516px',\r\n");
      out.write("\t\t  //skin: 'layui-bg-black', //没有背景色\r\n");
      out.write("\t\t  shade:0.5,\r\n");
      out.write("\t\t  shadeClose: false,\r\n");
      out.write("\t\t  content: 'views/dictionary/item.jsp?typeid=' + data.id,\r\n");
      out.write("\t\t});\r\n");
      out.write("  \t}\r\n");
      out.write("  \r\n");
      out.write("\t//点击添加按钮\r\n");
      out.write("\t$('#add-button').click(function(){\r\n");
      out.write("\t\tshowForm('添加字典',-1);\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("  function showForm(title,id){\r\n");
      out.write("  \tlayer.open({\r\n");
      out.write("  \t\t  type: 2,\r\n");
      out.write("  \t\t  title: title,\r\n");
      out.write("  \t\t  closeBtn: 1,\r\n");
      out.write("  \t\t  //area: '516px',\r\n");
      out.write("  \t\t  //skin: 'layui-bg-black', //没有背景色\r\n");
      out.write("  \t\t  shadeClose: false,\r\n");
      out.write("  \t\t  content: 'views/dictionary/edittype.jsp?id=' + id,\r\n");
      out.write("  \t\t  end:function(){\r\n");
      out.write("  \t\t\t\t//执行重载\r\n");
      out.write("  \t\t      table.reload('dictionary-table', {\r\n");
      out.write("  \t\t        /* page: {\r\n");
      out.write("  \t\t          curr: 1 //重新从第 1 页开始\r\n");
      out.write("  \t\t        } */\r\n");
      out.write("  \t\t      });\r\n");
      out.write("  \t\t  }\r\n");
      out.write("  \t\t});\r\n");
      out.write("    }\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_shiro_005fhasPermission_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_005fhasPermission_005f0 = (org.apache.shiro.web.tags.HasPermissionTag) _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_005fhasPermission_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasPermission_005f0.setParent(null);
    // /views/dictionary/dictionary.jsp(16,3) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f0.setName("20002");
    int _jspx_eval_shiro_005fhasPermission_005f0 = _jspx_th_shiro_005fhasPermission_005f0.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
        out.write("\t\t\t\t\t<button type=\"button\" class=\"layui-btn layui-btn-warm\" id=\"add-button\">添加</button>\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_005fhasPermission_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasPermission_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f0);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasPermission_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_005fhasPermission_005f1 = (org.apache.shiro.web.tags.HasPermissionTag) _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_005fhasPermission_005f1.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasPermission_005f1.setParent(null);
    // /views/dictionary/dictionary.jsp(22,3) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f1.setName("20004");
    int _jspx_eval_shiro_005fhasPermission_005f1 = _jspx_th_shiro_005fhasPermission_005f1.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
        out.write("\t\t\t\t\t<button type=\"button\" class=\"layui-btn layui-btn-danger layui-btn-normal\" id=\"delete-button\">删除</button>\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_005fhasPermission_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasPermission_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f1);
    return false;
  }
}