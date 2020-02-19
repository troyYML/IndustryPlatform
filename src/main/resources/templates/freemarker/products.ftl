

<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ie6ie7 oldie"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ie6ie7 oldie"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8 oldie"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="js wf-myriadpro-n4-active wf-myriadpro-n6-active wf-myriadpro-n7-active wf-active" lang="en"><!--<![endif]--><head>
    <#include "common/head.ftl">

</head>
<body class="page-subpage">
<p id="nav-skip">
    <a title="Go to content (Hot key: Alt + 2)" accesskey="2" href="#main">Go to content</a>
    <span class="hidden">|</span>
    <a href="#main-menu">Go to main menu</a>
</p>
<div id="wrap">
    <div id="header" style="background-image: url(images/poz-spolecnost.jpg)">
        <div id="header-wrap">
            <div class="row row-main">
                <h1 id="logo-box">
                    <span id="logo"><img src="${ctx}/static/img/logo.png" height="110" width="110"></span>
                    <span id="claim">${factoryName!}</span>
                </h1>
            </div>
        </div>
    </div>
    <hr class="hidden">
    <div id="main-menu" class="row row-main">
        <ul class="reset">


            <li id="menu-01" class="first" style="width: 196px"><a href="${ctx}/index">首 页</a></li>

            <li id="menu-02" style="width: 196px"><a href="${ctx}/about">公司简介</a></li>

            <li class="" id="menu-03" style="width: 196px"><a href="${ctx}/news">公司新闻</a></li>

            <li class="" id="menu-04" style="width: 196px"><strong class="active">产品中心</strong></li>

            <li id="menu-07" class="last" style="width: 196px"><a href="${ctx}/feedback">联络我们</a></li>

        </ul>

    </div>
    <div id="main" class="row row-main">
        <div class="row">
            <div class="content-box content-box-2cols">
                <div class="row">
                    <div class="col col-content">
                        <p id="breadcrumb"><a href="index">首页</a> <a href="${ctx}/products">产品中心</a> 产品展示 </p>
                        <h2>${factoryName!}</h2>




                        <div class="row share-line">
                            <div class="fl">

                            </div>
                            <div class="fr">

                                <a href="#" class="print">Print</a>
                            </div>
                        </div>



                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <#if productList?? && productList.list??>
                                    <#list productList.list as product>
                                        <#if product_index%3 == 0 >
                                        <tr>
                                            <td class="first">
                                        <#elseif product_index%3 == 1>
                                            <td>
                                        <#else>
                                            <td class="last">
                                        </#if>
                                            <table width="77%"  border="0" cellpadding="0" cellspacing="0">
                                                <tr>
                                                    <td align="center"><a href="${ctx}/productDetail?id=${product.id?c}"><img src="<#if product.pic??  && product.pic!=''>/profile/avatar/${product.pic}<#else>${ctx}/profile/profile.jpg</#if>" width="180" height="180" border="0" class="pro-img" style="border-color:#D5D5D5 " /></a></td>
                                                </tr>
                                            </table>
                                            <div align="center"> <a href="${ctx}/productDetail?id=${product.id?c}">${product.name!}</a></div>
                                        </td>
                                        <#if product_index%3 == 2></tr></#if>
                                    </#list>
                                </#if>

                            <tr>


                        </table>
                        <hr>
                        <table width="100%" border="0" cellspacing="3" cellpadding="0">
                            <tr>
                                <td valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
                                    <tr>
                                        <td width="10%" height="36" align="left">
                                            <div align="center"><a href="${ctx}/products?<#if menuId??>menuId=${menuId?c}&</#if>page=1"><font color="#000000">First</font></a></div></td>
                                        <td width="13%" align="left"><div align="center">
                                                <#if productList.isFirstPage == true>
                                                    ----
                                                <#else>
                                                    <a href="${ctx}/products?<#if menuId??>menuId=${menuId?c}&</#if>page=${productList.prePage}"> <font color="#000000">Prev</font></a>
                                                </#if>
                                        </div></td>
                                        <td width="12%" align="left"><div align="center">
                                                <#if productList.isLastPage == true>
                                                    ----
                                                <#else>
                                                    <a href="${ctx}/products?<#if menuId??>menuId=${menuId?c}&</#if>page=${productList.nextPage}"> <font color="#000000">Next</font></a>
                                                </#if>
                                            </div></td>
                                        </div></td>
                                        <td width="10%" align="left"><div align="center"> <a href="${ctx}/products?<#if menuId??>menuId=${menuId?c}&</#if>page=${productList.pages}"> <font color="#000000">Last</font></a></div></td>
                                        <td width="13%" align="left"><div align="center">Total:<span class="newform">${productList.pages}</span></div></td>
                                        <td width="17%" align="left"><div align="center">Nonce:<span class="newform">${productList.pageNum}</span></div></td>
                                        <form action="${ctx}/products<#if menuId??>?menuId=${menuId?c}</#if>" name="form3">
                                            <td width="13%" align="left" valign="middle"><div align="center">
                                                <input name="page" type="text" class="i1" id="text" size="3" maxlength="3">
                                            </div></td>
                                            <td width="12%" align="left" valign="middle"><div align="center">
                                                <input name="menuId" type="hidden" value="${menuId!}">
                                                <input name="Submit6" type="submit" class="input2" id="Submit6" value="GO">
                                            </div></td>
                                        </form>
                                    </tr>
                                </table></td>
                            </tr>
                        </table>



                        </p>
                    </div>

                    <div class="col col-side"><div class="side-box side-menu">
                        <div class="spc"><h2>产品目录</h2>
                            <ul class="reset">

                                <li>

                                <#if menuList??>
                                    <#list menuList as menu>
                                        <li>   <a href="${ctx}/products<#if menu.menuId??>?menuId=${menu.menuId?c}</#if>"><font color=#0e6f8f>${menu.menuName}</font></a><li>
                                    </#list>
                                </#if>
                            </li>

                            </ul>
                        </div></div>


                        <#include "common/searchSideBar.ftl"></div>						</div>
            </div>
        </div>

        <div class="row foot-crossroad">

        </div>			</div>
    <hr class="hidden">
</div>

<#include "common/searchBox.ftl">

<div id="head-links" class="reset">
    <div style="" class="wrap">
        <div class="box">


        </div>
    </div>
    <#include "common/language.ftl">
</div>



<#include "common/foot.ftl">

</body></html>