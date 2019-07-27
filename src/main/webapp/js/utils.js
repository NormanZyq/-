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
    $.ajax({
        url: "/course/selectCourse",
        method: "POST",
        data: {
            courseId: id
        },
        statusCode: {
            200: function () {
                alert("选课成功");
                // todo 更改按钮为已选
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


