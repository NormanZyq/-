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
    let card = `<div class="col-sm-4 mt-4">
        <div class="card m-auto shadow shadow-sm">
            <span id="test-id" style="display: none;">${test.testId}</span>
            <h3 class="card-title"><br /><br /><br />${test.courseName}</h3>
            <div class="card-body">
                <br />
                <table class="table">
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
            </div>
        </div>`;

    $('#exam').append(card);

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

    let content = `<tr>
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

function appendCQ(question, count) {
    let content = `<div class="card w-75 mx-auto shadow shadow-sm">
				<div class="card-header">第${count}题</div>
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
					<label><input type="radio" name="optradio0" id="cq-${count}">
						&nbsp;&nbsp;A&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<label><input type="radio" name="optradio0" id="cq-${count}">
						&nbsp;&nbsp;B&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<label><input type="radio" name="optradio0" id="cq-${count}">
						&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<label><input type="radio" name="optradio0" id="cq-${count}">
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
 * 获得URL参数
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







