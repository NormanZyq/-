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
                $('#btn-select-' + id).addClass('disabled').html('已选').onclick = function () {
                    alert('已选此课')
                };
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

function searchCoursesByName() {
    // todo 从搜索框获取name
    var name = "";

    $.ajax({
        url: "/course/get/" + name,
        statusCode: {
            200: function (result) {
                console.log(result);
                // todo 更新列表
            },
            404: function () {
                alert("无法连接到服务器");
            },
            500: function () {
                alert("服务器异常");
            }
        }
    })
}

function appendTestCard(test) {

    let card = `<div class="col-sm-3">
        <div class="card m-auto shadow shadow-sm">
            <span id="test-id" style="display: none;">${test.id}</span>
            <h3 class="card-title"><br /><br /><br />${test.name}</h3>
            <div class="card-body">
                <br />

                <table class="table">
                    <thead>
                        <tr>
                            <th>
                                <h5>考试课程</h5>
                            </th>
                            <th>${test.name}</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <h5>考试时间</h5>
                            </td>
                            <td>${test.time}</td>
                        </tr>
                        <tr>
                            <td>
                                <h5>考试时长</h5>
                            </td>
                            <td>${test.duration}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>`;

    $('#test-list').append(card);

}

function appendSearchResult(course) {
    console.log(course);
    var teacher = '';

    let length = course.teachers.length;

    if (length === 1) {
        teacher += course.teachers[0].name;
    } else if (length >= 2) {
        teacher += course.teachers[0].name;
        teacher += '、' + course.teachers[1].name;
        if (length > 2) {
            teacher += "等" + length + "人";
        }
    }

    let content = `<tr>
                        <td id="search-result-id" style="display: none;">${course.courseId}</td>
                        <td>${course.courseName}</td>
                        <td>${teacher}</td>
                        <td>
                            <div >
                                <button type="button" id="btn-select-${course.courseId}" class="btn btn-outline-success" onclick="selectCourse(${course.courseId})">加入</button>
                            </div>
                        </td>
                    </tr>`;

    $('#course-table-body').append(content);


}

