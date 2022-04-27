import CreateView from "../createView.js"
import {getHeaders} from "../auth.js";

const USER_URI = "http://localhost:8080/api/users";

export default function Register(props) {
    // language=html
    return `
        <!DOCTYPE html>
        <html lang="html">
        <head>
            <meta charset="UTF-8"/>
            <title>Register</title>
        </head>
        <body>
        <div class="container" id="register-container">
            <div class="card" id="register-card">
                <div class="card-header">
                    <h3>Register</h3>
                </div>
                <div class="card-body">
                    <form id="register-form">
                        <!--TODO: add username validation that checks for existing users with that name-->
                        <div class="mb-3">
                            <label for="register-username" class="form-label">Username</label>
                            <input type="text" class="form-control" id="register-username" name="username"
                                   placeholder="Create a username">
                        </div>
                        <!--TODO: add email validation that checks for the email to make sure it doesn't already exist-->
                        <div class="mb-3">
                            <label for="register-email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="register-email" name="email" placeholder="Type your email">
                        </div>
                        <!--TODO: add password validation -->
                        <div class="mb-3">
                            <label for="register-password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="register-password" name="password" placeholder="Create a password">
                        </div>
                    </form>
                </div>
                <div class="card-footer w-100" id="register-footer">
                    <input class="btn btn-primary" id="register-btn" type="submit" value="Register"/>
                </div>
            </div>
        </div>
        </body>
        </html>
    `;
}

export function RegisterEvent() {
    $("#register-btn").click(function () {

        let newUser = {
            username: $("#username").val(),
            email: $("#email").val(),
            password: $("#password").val()
        }

        let request = {
            method: "POST",
            headers: getHeaders(),
            body: JSON.stringify(newUser)
        }

        fetch(USER_URI, request)
            .then(response => {
                console.log(response.status);
            }).catch(error => {
            console.log(error.status)
        }).finally(() => {
            CreateView("/");
        });
    });
}