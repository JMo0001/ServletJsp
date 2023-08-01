<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath }/resources/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/projectname.css?after" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/projectname_layout.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/projectname_header.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/projectname_aside.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/projectname_section.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/responsive.css" rel="stylesheet">
<%@ include file ="/WEB-INF/view/aside.jsp" %>
<%@page errorPage="/WEB-INF/view/error/errorPage.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>


<!-- 반응형
meta viewport 전제 되어야 함
max-width 사용시 큰px 먼저 .. 작은 px로 작성
min-width 사용시 작은px 먼저 .. 큰px 작성
-->


</head>
<body>
    <%@ include file="/WEB-INF/view/header.jsp" %>
<jsp:include page="/WEB-INF/view/header.jsp"/>

<% 
int a = (int)request.getAttribute("abc");
request.getContextPath();
%>

    <div class="wrap content">
        <div id="content">
            <section>
                <article id="table_wrap">
                    <table>
                        <tbody>
                            <tr>
                                <th>제목1</th>
                                <th>제목1</th>
                                <th>제목1</th>
                                <th>제목1</th>
                            </tr>
                            <tr>
                                <td><div><img src="https://dummyimage.com/180/ccc"></div></td>
                                <td><div><img src="https://dummyimage.com/180/ccc"></div></td>
                                <td><div><img src="https://dummyimage.com/180/ccc"></div></td>
                                <td><div><img src="https://dummyimage.com/180/ccc"></div></td>
                            </tr>
                            <tr class="table-content">
                                <td><div>내용내용내용내용</div></td>
                                <td><div>내용내용내용내용</div></td>
                                <td><div>내용내용내용내용</div></td>
                                <td><div>내용내용내용내용</div></td>
                            </tr>
                        </tbody>
                    </table>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita excepturi aut perspiciatis, similique quia inventore rerum assumenda possimus incidunt omnis illum tempora porro quaerat, eveniet iusto error fugit enim delectus!</p>
                </article>
                <article>
                    <div id="grid_wrap">
                        <div>
                            <div class="flex-title">제목1</div>
                            <div class="flex-img"><img src="https://dummyimage.com/250/ccc" class="default-img"></div>
                            <div class="flex-content">
                                <div class="flex-category"><div>전통주</div><div>추천</div></div>
                                <div class="flex-content-title"><div>전통주 오마카세에서 하는</div></div>
                                <div class="flex-content-items"><div>클럽</div><div>.</div><div>강서구</div><div>.</div><div>2023-06-27</div></div>
                                <div class="flex-content-follow"><div><img src="https://dummyimage.com/15/ccc"></div><div><img src="https://dummyimage.com/15/ccc"></div><div>6/8</div></div>
                            </div>
                        </div>
                        <div>
                            <div class="flex-title">제목1</div>
                            <div class="flex-img"><img src="https://dummyimage.com/250/ccc" class="default-img"></div>
                            <div class="flex-content">
                                <div class="flex-category"><div>전통주</div><div>추천</div></div>
                                <div class="flex-content-title"><div>전통주 오마카세에서 하는</div></div>
                                <div class="flex-content-items"><div>클럽</div><div>.</div><div>강서구</div><div>.</div><div>2023-06-27</div></div>
                                <div class="flex-content-follow"><div><img src="https://dummyimage.com/15/ccc"></div><div><img src="https://dummyimage.com/15/ccc"></div><div>6/8</div></div>
                            </div>
                        </div>
                        <div>
                            <div class="flex-title">제목1</div>
                            <div class="flex-img"><img src="https://dummyimage.com/250/ccc" class="default-img"></div>
                            <div class="flex-content">
                                <div class="flex-category"><div>전통주</div><div>추천</div></div>
                                <div class="flex-content-title"><div>전통주 오마카세에서 하는</div></div>
                                <div class="flex-content-items"><div>클럽</div><div>.</div><div>강서구</div><div>.</div><div>2023-06-27</div></div>
                                <div class="flex-content-follow"><div><img src="https://dummyimage.com/15/ccc"></div><div><img src="https://dummyimage.com/15/ccc"></div><div>6/8</div></div>
                            </div>
                        </div>
                        <div>
                            <div class="flex-title">제목1</div>
                            <div class="flex-img"><img src="https://dummyimage.com/250/ccc" class="default-img"></div>
                            <div class="flex-content">
                                <div class="flex-category"><div>전통주</div><div>추천</div></div>
                                <div class="flex-content-title"><div>전통주 오마카세에서 하는</div></div>
                                <div class="flex-content-items"><div>클럽</div><div>.</div><div>강서구</div><div>.</div><div>2023-06-27</div></div>
                                <div class="flex-content-follow"><div><img src="https://dummyimage.com/15/ccc"></div><div><img src="https://dummyimage.com/15/ccc"></div><div>6/8</div></div>
                            </div>
                        </div>
                        <div>
                            <div class="flex-title">제목1</div>
                            <div class="flex-img"><img src="https://dummyimage.com/250/ccc" class="default-img"></div>
                            <div class="flex-content">
                                <div class="flex-category"><div>전통주</div><div>추천</div></div>
                                <div class="flex-content-title"><div>전통주 오마카세에서 하는</div></div>
                                <div class="flex-content-items"><div>클럽</div><div>.</div><div>강서구</div><div>.</div><div>2023-06-27</div></div>
                                <div class="flex-content-follow"><div><img src="https://dummyimage.com/15/ccc"></div><div><img src="https://dummyimage.com/15/ccc"></div><div>6/8</div></div>
                            </div>
                        </div>
                        <div>
                            <div class="flex-title">제목1</div>
                            <div class="flex-img"><img src="https://dummyimage.com/250/ccc" class="default-img"></div>
                            <div class="flex-content">
                                <div class="flex-category"><div>전통주</div><div>추천</div></div>
                                <div class="flex-content-title"><div>전통주 오마카세에서 하는</div></div>
                                <div class="flex-content-items"><div>클럽</div><div>.</div><div>강서구</div><div>.</div><div>2023-06-27</div></div>
                                <div class="flex-content-follow"><div><img src="https://dummyimage.com/15/ccc"></div><div><img src="https://dummyimage.com/15/ccc"></div><div>6/8</div></div>
                            </div>
                        </div>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita excepturi aut perspiciatis, similique quia inventore rerum assumenda possimus incidunt omnis illum tempora porro quaerat, eveniet iusto error fugit enim delectus!</p>
                </article>
                <article>
                    <div class="mission_a"><h2><a href="#">링크1</a></h2></div>
                    <div class="mission_a"><h2><a href="#">링크2</a></h2></div>
                    <div class="mission_a"><h2><a href="#">링크3</a></h2></div>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita excepturi aut perspiciatis, similique quia inventore rerum assumenda possimus incidunt omnis illum tempora porro quaerat, eveniet iusto error fugit enim delectus!</p>
                </article>
                <article>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita excepturi aut perspiciatis, similique quia inventore rerum assumenda possimus incidunt omnis illum tempora porro quaerat, eveniet iusto error fugit enim delectus!</p>
                </article>
                <article id="dom_div">
                    <button type="button" id="btnAddContent">더보기</button>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita excepturi aut perspiciatis, similique quia inventore rerum assumenda possimus incidunt omnis illum tempora porro quaerat, eveniet iusto error fugit enim delectus!</p>
                    <div class="flex_wrap">
                        <!-- <div>
                            <div class="flex-title">제목1</div>
                            <div class="flex-img"><img src="https://dummyimage.com/250/ccc" class="default-img"></div>
                            <div class="flex-content"></div>
                            <div class="flex-category"><div>전통주</div><div>추천</div></div>
                        </div> -->
                    </div>
<script>
    addDiv5();
    function addDiv5(){
        var htmlVal="";
        for( var i=0; i<5;i++){
            htmlVal+=`         
                        <div>
                            <div class="flex-title">제목1</div>
                            <div class="flex-img"><img src="https://dummyimage.com/250/ccc" class="default-img"></div>
                            <div class="flex-content"></div>
                            <div class="flex-category"><div>전통주</div><div>추천</div></div>
                        </div>
                        `;
        }
        $("#dom_div>.flex_wrap:last-of-type").append(htmlVal);                        
    }
    $("#btnAddContent").on("click", function(){
        var htmlVal='<div class="flex_wrap"></div>'
        $("#dom_div").append(htmlVal);
        addDiv5();
    });
</script>                            
                </article>
            </section>
            
        </div>
    </div>
    <%@ include file="/WEB-INF/view/footer.jsp" %>
    <script>
        var a1 = document.getElementById("test1").innerText;
        document.getElementById("test1").innerHTML = "<b>바!꿈!</b>";
    </script>
</body>
</html>