var main = {
    init : function () {
        var _this = this;
        $('#btn-login').on('click', function (){
            _this.login();
        });
    },
    login : function () {
        var data = {
            email: $('#email').val(),
            password: $('#password').val()
        };

        $.ajax({
            type: 'POST',
            url: '/login',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('로그인 성공!!');
            window.location.href='/';
        }).fail(function() {
            alert(JSON.stringify(error));
        });
    }
};

main.init();