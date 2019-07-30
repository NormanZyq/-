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

function getTests() {
    $('#exam').html('');

    $.ajax({
        url: "/test/get/all",
        type: "POST",
        dataType: "json",
        success: function (result) {
            for (let test of result) {
                console.log(test);
                appendTestCard(test)
            }
        },
        error: function (result) {
            alert(result)
        }
    })
}

function getXuanze(testId) {
    $('#exer').html('');
    // 获得选择题
    $.ajax({
        url: "/test/get/xuanze",
        type: "POST",
        dataType: "json",
        data: {
            testId: testId
        },
        success: function (result) {
            // 解析选择题
            console.log(result);
            var index = 1;
            for (question of result) {
                appendCQ(question, index);
                index++;
            }
        },
        error: function (result) {
            alert(result);
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
            // 解析选择题
            console.log(result);
            var index = 1;
            for (question of result) {
                appendSQ(question, index);
                index++;
            }
        },
        error: function (result) {
            alert(result);
            console.log(result);
        }
    })

}





