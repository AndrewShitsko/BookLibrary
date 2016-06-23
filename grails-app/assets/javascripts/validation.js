var errorIcon = "<i class='fa fa-exclamation-triangle'></i>";
$(document).ready(function() {
    $("#bookForm").validate({
        rules: {
            title: "required",
            author: "required",
            description: "required",
            publishYear: {
                required: true,
                number: true
            },
            bookUrl: {
                required: true,
                url: true
            }
        },
        messages: {
            title: "Input title",
            author: "Input author",
            description: "Input description",
            publishYear: {
                required: "Input publish year",
                number: "Publish year must be a number"
            },
            bookUrl: {
                required: "Input url",
                url: "Input valid url"
            }
        },
        showErrors: function (errorMap, errorList) {
            this.defaultShowErrors();
            $("label.error").children().remove("i");
            $("label.error").prepend(errorIcon);
        }
    });

    $("#loginForm").validate({
        rules: {
            username: "required",
            password: "required"
        },
        messages: {
            username: "Input username",
            password: "Input password"
        },
        showErrors: function (errorMap, errorList) {
            this.defaultShowErrors();
            $("label.error").children().remove("i");
            $("label.error").prepend(errorIcon);
        }
    });

    $("#userForm").validate({
        rules: {
            username: {
                required: true,
                minlength: 4
            },
            password: {
                required: true,
                minlength: 8
            },
            email: {
                required: true,
                email: true
            },
            firstname: "required",
            lastname: "required",
            middlename: "required"
        },
        messages: {
            username: {
                required: "Input username",
                minlength: "Username must be at least 4 characters"
            },
            password: {
                required: "Input password",
                minlength: "Password must be at least 8 characters"
            },
            email: {
                required: "Input email",
                email: "Input valid email"
            },
            firstname: "Input firstname",
            lastname: "Input lastname",
            middlename: "Input middlename"
        },
        showErrors: function (errorMap, errorList) {
            this.defaultShowErrors();
            $("label.error").children().remove("i");
            $("label.error").prepend(errorIcon);
        }
    });

    $("#roleForm").validate({
        rules: {
            name: "required"
        },
        messages: {
            name: "Input role name"
        },
        showErrors: function (errorMap, errorList) {
            this.defaultShowErrors();
            $("label.error").children().remove("i");
            $("label.error").prepend(errorIcon);
        }
    });
});
