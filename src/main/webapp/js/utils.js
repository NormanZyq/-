var userId = null;

function navBar() {
    let navigation = `<nav class="navbar navbar-expand-lg navbar-light shadow shadow-sm rounded rounded-bottom rounded-top" style="background-color: #c9ecfd;">
            <a class="navbar-brand" href="#"><img src="/rua.jpg" height="44px"><span class="text-primary"> [谁来起个名字(￣∇￣)]</span></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarColor03">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item" id="index-page">
                        <a class="nav-link" href="/index">首页</a>
                    </li>
                    <li class="nav-item" id="login-page">
                        <a class="nav-link" href="/login">登录</a>
                    </li>
                    <li class="nav-item" id="about-page">
                        <a class="nav-link" href="#">关于</a>
                    </li>
                </ul>
            </div>
        </nav>`;

    $('body').before(navigation);
}

function sendRequest(url, method, data, id) {
    var mId = id;
    if (method === 'GET') {

    } else if (method === 'POST') {

    }
}

function processResult(data, id) {
    if (id === 1) {
        // todo
    }
}


function makeActive(id) {
    $('#' + id).addClass("active");
}


function selectCourse(id) {
    alert(id);
    $.ajax({
        url: "/course/selectCourse",
        method: "POST",
        data: {
            courseId: id
        },
        statusCode: {
            200: function () {
                alert("选课成功");
                $('#btn-select-' + id).addClass('disabled').html('已选').onclick(function () {
                    alert('已选此课');
                })
            },
            404: function () {
                alert("无法连接到服务器");
            },
            701: function () {
                alert("选课失败，请重试");
            },
            500: function () {
                alert("服务器异常");
            }
        }
    })
}

function appendTestCard(test) {
    let status = test.identity;

    var tip;
    var textClass = '';
    var btn = '';

    if (status === 1) {
        textClass = 'text-danger';
        btn = "<a class='btn btn-sm btn-outline-primary' href='/exam.html?testId=" + test.testId + "'>进入</a>";
        tip = '考试进行中';
    } else if (status === 0) {
        // textClass = 'text-danger';
        tip = '考试已结束';
    } else if (status === -1) {
        tip = '考试未开始';
    }

    let card = `<div class="col-sm-4 mt-4">
        <div class="card m-auto shadow shadow-sm">
            <span id="test-id" style="display: none;">${test.testId}</span>
            <h3 class="card-title"><br /><br /><br />${test.courseName}</h3>
            <div class="card-body">
                <p class="text-center"><h5 class="${textClass}">${tip}</h5></p>
                <table class="table mt-5">
                    <thead>
                        <tr>
                            <th>
                                <h5>考试课程</h5>
                            </th>
                            <th><h5>${test.courseName}</h5></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <h5>考试时间</h5>
                            </td>
                            <td>${test.startTime}</td>
                        </tr>
                        <tr>
                            <td>
                                <h5>考试时长</h5>
                            </td>
                            <td>${test.duration} 分钟</td>
                        </tr>
                    </tbody>
                </table>
                ${btn}
            </div>
        </div>`;

    $('#exam').append(card);
}

function appendTeacherTest(test) {
    var cqCount;
    var sqCount;
    if (test.choiceQuestionIds.trim() === "") {
        cqCount = 0;
    } else {
        cqCount = test.choiceQuestionIds.split(' ').length;
    }
    if (test.subjectiveQuestionIds.trim() === "") {
        sqCount = 0;
    } else {
        sqCount = test.subjectiveQuestionIds.split(' ').length;
    }

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

    var button = ``;
    if (time === undefined) {
        // 考试未发布
        button =
            `<button type="button" class="btn btn-outline-warning" onclick="releaseTest(${test.testId})">发布试卷</button>
            &nbsp;
            <button type="button" class="btn btn-outline-warning" onclick="deleteTest(${test.testId})">删除</button>`;
    } else {
        // 考试已发布
        button = `<button type="button" class="btn btn-outline-warning disabled" onclick="">试卷已发布</button>`;

    }

    let content =
        `<tr>
            <td>${test.courseName}</td>
            <td>${cqCount}</td>
            <td>${sqCount}</td>
            <td>${button}</td>
        </tr>`;
    $('#exerbody2').append(content);
}

function releaseTest(id) {
    $.ajax({
        url: '/arrange',
        type: "POST",
        data: {
            testId: id,
            startTime: '20190801150000',
            duration: 90
        },
        success: function (result) {
            alert('考试已发布');
        },
        error: function (result) {
            alert('发布失败');
        }
    })
}

function deleteTest(id) {
    $.ajax({
        url: '/delete',
        type: "POST",
        data: {
            testId: id
        },
        success: function (result) {
            alert('删除成功！')
        },
        error: function (result) {
            alert('删除失败');
        }
    })
}

function appendStartedTestCard(test) {
    let content =
        `<div class="card">
            <div class="card-header">
                <a class="card-link" data-toggle="collapse" href="#collapseOne">
                    <div class="float-left">
                        ${test.courseName}
                    </div>
                    <div class="float-right">
                        <a href="/exam/${test.testId}" class="btn btn-sm btn-outline-info">&nbsp;&nbsp;&nbsp;&nbsp;进入&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    </div>
                </a>
            </div>
            <div id="collapseOne" class="collapse show" data-parent="#accordion">
                <div class="card-body">
                    <div class="container">
                        <p>科目：${test.courseName}</p>
                        <p>开始时间：${test.startTime}</p>
                        <p>考试时长：${test.duration}分钟</p>
                    </div>
                </div>
            </div>
        </div>`;

    $('#st-accordion').append(content);

}

function appendSearchResult(course) {
    var teacherString = '';

    var teachers = new Set(course.teachers);

    let size = teachers.size;

    var count = 0;
    for (let t of teachers) {
        count++;
        teacherString += t.name + " ";
        if (size >= 2) {
            teacherString += "等多人";
            break;
        }
    }

    let content =
        `<tr>
            <td id="search-result-id" style="display: none;">${course.courseId}</td>
            <td>${course.courseName}</td>
            <td>${teacherString}</td>
            <td>
                <div >
                    <button type="button" id="btn-select-${course.courseId}" class="btn btn-outline-success" onclick="selectCourse(${course.courseId})">加入</button>
                </div>
            </td>
        </tr>`;

    $('#course-table-body').append(content);
}

function appendSelectedResult(course) {
    var teacherString = '';

    var teachers = new Set(course.teachers);

    let size = teachers.size;

    var count = 0;
    for (let t of teachers) {
        count++;
        teacherString += t.name + " ";
        if (size >= 2) {
            teacherString += "等多人";
            break;
        }
    }

    let content = `<tr>
                        <td id="search-result-id" style="display: none;">${course.courseId}</td>
                        <td>${course.courseName}</td>
                        <td>${teacherString}</td>
                    </tr>`;

    $('#selected-table-body').append(content);
}

function appendCQ(question, index) {
    let content = `<div class="card w-75 mx-auto shadow shadow-sm">
				<div class="card-header">第${index}题</div>
				<div class="card-body">${question.questionContent}`;

    let choicesString = ``;
    for (var key in question.choices) {
        choicesString += `<br><br>${key}: ${question.choices[key]}`;
    }
    choicesString += `<br><br>`;

    content += choicesString;

    // 题目内容<br /><br />${question.d}<br /><br />B<br /><br />C<br /><br />D<br /><br />
    let selectField = `</div>
				<div class="card-footer">
					<label><input type="radio" name="optradio-${index}" id="cq-${index}" value="A">
						&nbsp;&nbsp;A&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<label><input type="radio" name="optradio-${index}" id="cq-${index}" value="B">
						&nbsp;&nbsp;B&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<label><input type="radio" name="optradio-${index}" id="cq-${index}" value="C">
						&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<label><input type="radio" name="optradio-${index}" id="cq-${index}" value="D">
						&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
				</div>
			</div>
			<br />`;
    content += selectField;
    $('#exer').append(content);

}

function appendSQ(question, index) {
    // todo 需要主观题的卡片
}

/**
 * 获得URL参数。
 */
function getRequestParam() {
    let params = location.search;
    let request = {};
    if (params.indexOf('?') !== -1) {
        let str = params.substr(1);
        strs = str.split('&');
        for (let i = 0; i < strs.length; i++) {
            request[strs[i].split('=')[0]] = unescape(strs[i].split('=')[1]);
        }
        return request;
    }
}

function calScores(id) {
    $.ajax({
        url: "/answer/calScore",
        type: "POST",
        async: false,
        data: {
            testId: id
        },
        success: function (result) {
            alert('自动评分成功！')
        }
    })
}






