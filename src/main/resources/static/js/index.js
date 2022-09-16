var main = {
    init : function () {
        var _this = this;
        $('#btn-login').on('click', function () {
            _this.login();
        });

         $('#btn-join').on('click', function () {
            _this.join();
         });

    },

    login : function () {
        var data = {
            email: $('#email').val(),
            password: $('#password').val(),
        };

        $.ajax({
            type: 'POST',
            url: '/login',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('로그인 완료');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    join : function () {
            var data = {
                email: $('#email').val(),
                password: $('#password').val(),
            };

            $.ajax({
                type: 'POST',
                url: '/join',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('회원가입 완료');
                window.location.href = '/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
    }

};

main.init();