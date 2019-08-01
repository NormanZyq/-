// import * as $ from "/js/jquery-3.3.1";

function getSelectedCourse() {
    $('#selected-table-body').html('');
    $.ajax({
        url: "/course/get/my",
        dataType: "json",
        success: function (result) {
            // 解析选课内容
            for (let course of result) {
                appendSelectedResult(course);
            }
        }
    })
}

function getUserInfo() {
    $.ajax({
        url: "/user/get/login",
        dataType: "json",
        async: false,
        success: function (result) {
            $('#t1').html(result.userId);
            $('#t2').html(result.name);
            $('#psw').html('---');

        }
    })
}

function getTeachCourse() {
    $('#my-course-dropdown').html('');
    $.ajax({
        url: "/course/get/my",
        dataType: "json",

        success: function (result) {
            // 解析选课内容
            for (let course of result) {
                let content = `<a class="dropdown-item" onclick="getQuestions('` + course.courseId + `');$('#course-name').html('` + course.courseName + `');">${course.courseName}</a>`;
                $('#my-course-dropdown').append(content);
                updatingCourseId = course.courseId;
            }
        }
    })
}

function getQuestions(courseId) {
    $("#exerbody1").html('');
    $.ajax({
        url: '/question/get/cq/' + courseId,
        type: 'get',
        dataType: 'json',
        success: function (data) {
            if (data.length === 0) {
                $("#exerbody1").append(`<p class="text-center">该课程还没有题目</p>`);
                return;
            }

            var tr1 = `<tr><th>题目内容</th><th>类型</th><th>操作</th></tr>`;

            for (question of data) {
                tr1 += `<tr><td>${question.questionContent}</td>`;
                if (question.questionType === 0) {
                    // 选择题
                    tr1 += `<td>选择题</td>`
                } else if (question.questionType === 1) {
                    // 主观题
                    tr1 += `<td>主观题</td>`
                } else {
                    // 其他（不存在的）
                }
                tr1 += `<td><a type="button" class="btn btn-outline-info" href="/exercise.html?id=${question.questionId}&course=${courseId}">修改</a></td></tr>`;
            }
            $("#exerbody1").append(tr1);

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            // 状态码
            console.log(XMLHttpRequest.status);
            // 状态
            console.log(XMLHttpRequest.readyState);
            // 错误信息
            console.log(textStatus);
        }
    })
}

function searchCourses() {
    $('#course-table-body').html('');
    let name = $('#search-content').val();
    $.ajax({
        url: "/course/get/" + name,
        type: "GET",
        dataType: "json",
        success: function (result) {
            console.log(result);
            // 解析结果
            if (result.length === 0) {
                $('#course-table-body').html("<p class='text-center'>未找到课程</p>")
            }
            for (course of result) {
                appendSearchResult(course);
            }
        },
        error: function (result) {
            alert(result);
            console.log(result);
        }
    })
}

/**
 * 获得所有考试。
 */
function getStudentTests() {
    $('#exam').html('');

    $.ajax({
        url: "/test/get/all",
        type: "POST",
        dataType: "json",
        success: function (result) {
            for (let test of result) {
                appendTestCard(test)
            }
        },
        error: function (result) {
            alert(result)
        }
    })
}

function getTeacherTests() {
    $('#exerbody2').html('<tr>' +
        '<th>课程名称</th>' +
        '<th>选择题数量</th>' +
        '<th>主观题数量</th>' +
        '<th>操作</th>' +
        '</tr>');

    $.ajax({
        url: "/test/get/all2",
        type: "POST",
        dataType: "json",
        success: function (result) {
            for (let test of result) {
                appendTeacherTest(test)
            }
        },
        error: function (result) {
            alert('获取考试失败惹')
        }
    })
}

function getStartedTests() {
    $('#st-accordion').html('');

    $.ajax({
        url: "/test/get/started",
        type: "POST",
        dataType: "json",
        success: function (result) {
            if (result.length === 0) {
                $('#st-accordion').html('<p class="text-center">当前没有正在进行的考试</p>')
            }
            // result
            for (let test of result) {
                appendStartedTestCard(test);
            }
        },
        error: function (result) {
            alert("获取考试信息出错，请刷新页面");
        }
    })
}

/**
 * 获得选择题。
 * @param testId 考试ID
 */
function getXuanze(testId) {
    $('#exer').html('');
    // 获得选择题
    $.ajax({
        url: "/test/get/xuanze",
        type: "POST",
        dataType: "json",
        // async: false,
        data: {
            testId: testId
        },
        success: function (result) {
            // 解析选择题
            // console.log(result);
            var index = 1;
            for (question of result) {
                appendCQ(question, index);
                index++;
            }
            return index;
        },
        error: function (result) {
            alert('获取选择题出错，请刷新页面');
            console.log(result);
        }
    })
}

function getZhuguan(testId, clear) {
    if (clear) {
        $('#exer').html('');
    }
    // 获得主观题
    $.ajax({
        url: "/test/get/zhuguan",
        type: "POST",
        dataType: "json",
        data: {
            testId: testId
        },
        success: function (result) {
            // 解析主观题
            // console.log(result);
            var index = 1;
            for (question of result) {
                appendSQ(question, index);
                index++;
            }
        },
        error: function (result) {
            alert('获取主观题出错，请刷新页面');
            console.log(result);
        }
    })
}

function getQuestionById(id) {
    $.ajax({
        url: "/question/get/" + id,
        type: "GET",
        dataType: "json",
        success: function (result) {
            // 更新界面
            if (result.questionType === 0) {
                // 选择题
                $('#ke').attr('checked', 'checked');
                $('#question-content').val(result.questionContent);
                $('#c-a').val(result.choices.A);
                $('#c-b').val(result.choices.B);
                $('#c-c').val(result.choices.C);
                $('#c-d').val(result.choices.D);

                // let choices = `<br>A. ${}<br /><br />B. ${}<br /><br />C. ${}<br /><br />D. ${}<br /><br />`;
                // $('#sel-content').html(choices);

                let rightAns = result.rightAnswer[0];

                typ();

                $('#ex-' + rightAns).attr("checked", "checked");

            } else if (result.questionType === 1) {
                // 主观题
                $('#zu').attr('checked', 'checked');
                typ();
            } else {
                // 不存在
            }


        },
        error: function (result) {
            alert('获取题目详情失败，请刷新页面');
            console.log(result);
        }
    })
}

function checkTests() {
    $("#accordion1").html('');

    $(function () {
        $.ajax({
            url: '/test/get/all2',
            type: 'POST',
            dataType: 'json',
            async: false,
            success: function (data) {
                console.log(data);

                var tr1 = "";
                for (let test of data) {
                    var time = undefined;
                    $.ajax({
                        url: '/test/get/time',
                        type: 'GET',
                        async: false,
                        data: {
                            testId: test.testId
                        },
                        success: function (result) {
                            time = result;
                        }
                    });

                    if (time === 0) {
                        // 考试已结束
                        tr1 += '<div class="card">' + '<div class="card-header">' + '<a class="collapsed card-link" data-toggle="collapse">';

                        tr1 += '<div class="float-left">' + '考试科目 ： ' + test.courseName + '</div>' + '<div class="float-right">';

                        tr1 += '<button onclick="calScores(' + test.testId + ')" type="button" class="btn btn-sm btn-outline-info">&nbsp;&nbsp;&nbsp;&nbsp;' + '自动评卷' + '&nbsp;&nbsp;&nbsp;&nbsp;' + '</button>' + '</div>' + '</a>' + '</div>'

                        // tr1+='<div id="collapse'+i+'" class="collapse" data-parent="#accordion">'+'<div class="card-body">'
                        //
                        // tr1+='<div class=" m-auto">'+'学生ID :'+data.data[i].studentid+'&nbsp;&nbsp;'+'学生姓名:'+ data.data[i].studentname+'&nbsp;&nbsp;&nbsp;&nbsp;'+'客观题得分:'+data.data[i].mark+'&nbsp;&nbsp;</div>'+'</div>'+'</div>'+'</div>'
                    }

                }
                $("#accordion1").append(tr1);


            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                // 状态码
                console.log(XMLHttpRequest.status);
                // 状态
                console.log(XMLHttpRequest.readyState);
                // 错误信息
                console.log(textStatus);
            }
        })
    })
}

/**
 * 教师获得考试情况（最高分最低分平均分）
 */
function teacherGetScores() {
    $('#body5').html('');
    $.ajax({
        url: "/test/get/all2",
        type: "POST",
        dataType: "json",
        success: function (result) {
            console.log(result);
            for (let test of result) {
                let testId = test.testId;
                $.ajax({
                    url: '/answer/ranks/' + testId,
                    success: function (scoreData) {
                        if (scoreData !== undefined
                            && scoreData != null
                            && scoreData !== '') {
                            let content =
                                `<tr>
                                <td>${test.courseName}</td>
                                <td>${scoreData.average}</td>
                                <td>${scoreData.max}</td>
                                <td>${scoreData.min}</td>
                            </tr>`;
                            $("#body5").append(content);
                        }

                    }

                })
            }
        },
        error: function (result) {
            alert('获取考试失败惹')
        }
    })
}

function studentGetScores() {
    $('#coursebody').html('');
    // 首先获得考试列表
    $.ajax({
        url: '/test/get/all',
        type: 'POST',
        success: function (result) {
            console.log(result);
            // 对每个考试查询分数和排名
            for (let test of result) {
                let testId = test.testId;
                $.ajax({
                    url: '/answer/rank/' + testId,
                    success: function (data) {
                        console.log(data);
                        if (data !== undefined
                            && data != null
                            && data !== '') {
                            let content = `<tr><td>${test.courseName}</td><td>${data.choicesScore + data.subjectiveScore}</td><td>${data.scoreRank}</td></tr>`;
                            $('#coursebody').append(content);
                        }

                    }
                })
            }
        }
    })
}


