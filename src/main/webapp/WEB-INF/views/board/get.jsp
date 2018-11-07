<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2018-11-04
  Time: 오후 7:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../includes/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Register</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board Read Page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="form-group">
                    <label>Bno</label>
                    <input class="form-control" name="bno" value="<c:out value='${board.bno}' />" readonly="readonly">
                </div>
                <div class="form-group">
                    <label>Title</label>
                    <input class="form-control" name="title" value="<c:out value='${board.title}' />" readonly="readonly">
                </div>
                <div class="form-group">
                    <label>Text area</label>
                    <textarea class="form-control" rows="3" name="content" readonly="readonly"><c:out value='${board.content}' /></textarea>
                </div>
                <div class="form-group">
                    <label>Writer</label>
                    <input class="form-control" name="writer" value="<c:out value='${board.writer}' />" readonly="readonly">
                </div>
                <button data-oper="modify" class="btn btn-default">Modify</button>
                <button data-oper="list" class="btn btn-info">List</button>

                <form action="/board/modify" method="get" id="operFrom">
                    <input type="hidden" id="bno" name="bno" value="<c:out value='${board.bno}'/>">
                    <input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum}'/>">
                    <input type="hidden" name="amount" value="<c:out value='${cri.amount}'/>">
                    <input type="hidden" name="keyword" value="<c:out value='${cri.keyword}'/>">
                    <input type="hidden" name="type" value="<c:out value='${cri.type}'/>">
                </form>

            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <!-- panel -->
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="fa fa-comments fa-fw"></i> Reply
                <button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">New Reply</button>
            </div>
            <div class="panel-body">
                <ul class="chat">
                    <!-- start reply -->
                    <%--<li class="left clearfix" data-rno="12">--%>
                        <%--<div>--%>
                            <%--<div class="header">--%>
                                <%--<strong class="primary-font">user00</strong>--%>
                                <%--<small class="pull-right text-muted">2018-01-01 13:13</small>--%>
                            <%--</div>--%>
                            <%--<p>Good job!</p>--%>
                        <%--</div>--%>
                    <%--</li>--%>
                    <!-- End reply -->
                </ul>
                <!-- End ul -->
            </div>
            <!-- End panel-body -->
            <div class="panel-footer">

            </div>
        </div>
        <!-- End panel .chat-panel -->
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>Reply</label>
                    <input class="form-control" name="reply" value="New Reply!!!">
                </div>
                <div class="form-group">
                    <label>Replyer</label>
                    <input class="form-control" name="replyer" value="replyer">
                </div>
                <div class="form-group">
                    <label>Reply Date</label>
                    <input class="form-control" name="replyDate" value="">
                </div>
            </div>
            <div class="modal-footer">
                <button id="modalModBtn" type="button" class="btn btn-warning">Modify</button>
                <button id="modalRemoveBtn" type="button" class="btn btn-danger">Remove</button>
                <button id="modalRegisterBtn" type="button" class="btn btn-primary">Register</button>
                <button id="modalCloseBtn" type="button" class="btn btn-default">Close</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<!-- End row -->
<script type="text/javascript" src="/resources/js/reply.js"></script>
<%--<script>--%>
    <%--console.log('오후 5:06', 'get.jsp:61', 'test');--%>
    <%--var bnoValue = '<c:out value="${board.bno}"/>';--%>
    <%--// replyService.add(--%>
    <%--//     {reply: "JS TEST", replyer: "tester", bno: bnoValue},--%>
    <%--//     function (result) {--%>
    <%--//         alert("RESULT: " + result);--%>
    <%--//     }--%>
    <%--// );--%>
    <%--// replyService.getList({bno: bnoValue, page: 1}, function (list) {--%>
    <%--//     for(var i = 0, len = list.length || 0; i < len; i++) {--%>
    <%--//         console.log('오후 5:29', 'get.jsp:71', list[i]);--%>
    <%--//     }--%>
    <%--// });--%>
    <%--// replyService.remove(23, function (count) {--%>
    <%--//     console.log('오후 5:33', 'get.jsp:75', count);--%>
    <%--//     if(count === "success") alert("REMOVED");--%>
    <%--// }, function (err) {--%>
    <%--//     alert(err);--%>
    <%--// });--%>
    <%--// replyService.update({--%>
    <%--//     rno: 22,--%>
    <%--//     bno: bnoValue,--%>
    <%--//     reply: "Modified Reply..."--%>
    <%--// }, function (result) {--%>
    <%--//     alert("수정 완료");--%>
    <%--// });--%>
    <%--// replyService.get(10, function (data) {--%>
    <%--//     console.log('오후 5:47', 'get.jsp:88', data);--%>
    <%--// });--%>
<%--</script>--%>
<script type="text/javascript">
$(document).ready(function () {
    var operForm = $("#operFrom");
    $("button[data-oper='modify']").on("click", function (e) {
        operForm.attr("action", "/board/modify").submit();
    });
    $("button[data-oper='list']").on("click", function (e) {
        operForm.find("#bno").remove();
        operForm.attr("action", "/board/list");
        operForm.submit();
    });
    // 댓글 관련
    var bnoValue = '<c:out value="${board.bno}"/>';
    var replyUL = $(".chat");
    showList(1);
    function showList(page) {
        replyService.getList({bno: bnoValue, page: page||1},
        // function (list) {
        //     var str="";
        //     if(list == null || list.length == 0) {
        //         replyUL.html("");
        //         return;
        //     }
        //     for(var i = 0, len = list.length || 0; i < len; i++) {
        //         str += "<li class='left clearfix' data-rno='" + list[i].rno + "'>";
        //         str += "    <div><div class='header'><strong class='primary-font'>"
        //                 + list[i].replyer + "</strong>";
        //         str += "        <small class='pull-right text-muted'>" + replyService.displayTime(list[i].replyDate) + "</small></div>";
        //         str += "    <p>" + list[i].reply + "</p></div></li>";
        //     }
        //     replyUL.html(str);
        // }); // end Function list
            // 페이징처리
            function (replyCnt, list) {
                if(page === -1) {
                    pageNum = Math.ceil(replyCnt / 10.0);
                    showList(pageNum);
                    return;
                }
                var str="";
                if(list === null || list.length === 0) {
                    return;
                }
                for(var i = 0, len = list.length || 0; i < len; i++) {
                    str += "<li class='left clearfix' data-rno='" + list[i].rno + "'>";
                    str += "    <div><div class='header'><strong class='primary-font'>["
                        + list[i].rno + "] " + list[i].replyer + "</strong>";
                    str += "        <small class='pull-right text-muted'>" + replyService.displayTime(list[i].replyDate) + "</small></div>";
                    str += "    <p>" + list[i].reply + "</p></div></li>";
                }
                replyUL.html(str);
                showReplyPage(replyCnt);
            }); // end Function list
    }// End Function showList

    //댓글 페이징
    var pageNum = 1;
    var replyPageFooter = $(".panel-footer");

    function showReplyPage(replyCnt) {
        var endNum = Math.ceil(pageNum/10.0) * 10;
        var startNum = endNum - 9;

        var prev = startNum != 1;
        var next = false;

        if(endNum * 10 >= replyCnt) {
            endNum = Math.ceil(replyCnt/10.0);
        }
        if(endNum * 10 < replyCnt) {
            next = true;
        }
        var str = "<ul class='pagination pull-right'>";
        if(prev) {
            str += "<li class='page-item'><a class='page-link' href='" + (startNum - 1) + "'>Previous</a></li>";
        }

        for(var i = startNum; i <= endNum; i++){
            var active = pageNum == i ? "active" : "";
            str += "<li class='page-item " + active + " '><a class='page-link' href='" + i + "'>" + i + "</a></li>";
        }

        if(next) {
            str += "<li class='page-item'><a class='page-link' href='" + (endNum + 1) +"'>Next</a></li>";
        }
        str += "</ul></div>";
        replyPageFooter.html(str);
    }

    //댓글 페이지 움직일시 새로운 댓글을 가져오도록 처리
    replyPageFooter.on("click", "li a", function (e) {
        e.preventDefault();
        var targetPageNum = $(this).attr("href");
        pageNum = targetPageNum;
        showList(pageNum);
    });

    // Modal
    var modal = $(".modal");
    var modalInputReply = modal.find("input[name='reply']");
    var modalInputReplyer = modal.find("input[name='replyer']");
    var modalInputReplyDate = modal.find("input[name='replyDate']");

    var modalModBtn = $("#modalModBtn");
    var modalRemoveBtn = $("#modalRemoveBtn");
    var modalRegisterBtn = $("#modalRegisterBtn");
    var modalCloseBtn = $("#modalCloseBtn");

    //모달 닫기
    modalCloseBtn.on("click", function (e) {
        e.preventDefault();
        modal.modal("hide");
    });
    //댓글 입력
    $("#addReplyBtn").on("click", function (e) {
        modal.find("input").val("");
        modalInputReplyDate.closest("div").hide();
        modal.find("button[id != 'modalCloseBtn']").hide();

        modalRegisterBtn.show();
        $(".modal").modal("show");
        modalRegisterBtn.on("click", function (e) {
            var reply = {
                reply: modalInputReply.val(),
                replyer: modalInputReplyer.val(),
                bno: bnoValue
            };
            replyService.add(reply, function (result) {
                alert(result);
                modal.find("input").val("");
                modal.modal("hide");
                // showList(1);
                //페이징 처리는 등록후 -1을 전달해 마지막 페이지를 찾아서 다시 호출하게 함.
                showList(-1);
            });
        });
    });
    //댓글 클릭 이벤트
    $(".chat").on("click", "li", function (e) {
        var rno = $(this).data("rno");
        replyService.get(rno, function (reply) {
            modalInputReply.val(reply.reply);
            modalInputReplyer.val(reply.replyer);
            modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly", "readonly");
            modal.data("rno", reply.rno);

            modal.find("button[id != 'modalCloseBtn']").hide();
            modalModBtn.show();
            modalRemoveBtn.show();

            $(".modal").modal("show");
        });
    });
    //댓글 수정
    modalModBtn.on("click", function (e) {
        var reply = {rno: modal.data("rno"), reply: modalInputReply.val()};
        replyService.update(reply, function (result) {
            alert(result);
            modal.modal("hide");
            // showList(1);
            showList(pageNum);
        });
    });

    //댓글 삭제
    modalRemoveBtn.on("click", function (e) {
        var rno = modal.data("rno");
        replyService.remove(rno, function (result) {
            alert(result);
            modal.modal("hide");
            // showList(1);
            showList(pageNum);
        });
    })
});

</script>

<%@ include file="../includes/footer.jsp" %>