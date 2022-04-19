"use strict";

const PASSWORD_URI = "http://localhost:8080/api/users/changePassword";
import CreateView from "../createView";

export default function changePassword(props) {
    //language=html
    return `
        <!DOCTYPE html>
        <html>
        <head>
            <meta charset="UTF-8"/>
            <title>Change Password</title>
        </head>
        <body>
        <h1>Change Password</h1>
        <form id="change-password">
            <div class="mb-3">
                <label for="input-username" class="form-label">Username</label>
                <input type="email" class="form-control" id="input-username" placeholder="Your username">
                <div class="mb-3">
                    <label for="input-old-password" class="form-label">Old Password</label>
                    <input type="password" class="form-control" id="input-old-password"
                           placeholder="Input your old password">
                    <div class="mb-3">
                        <label for="input-new-password" class="form-label">Password</label>
                        <input type="password" id="input-new-password" class="form-control"
                               aria-describedby="passwordHelpBlock">
                        <div id="passwordHelpBlock" class="form-text">
                            Your password must be 8-20 characters long, contain letters and numbers, and must not
                            contain spaces, special characters, or emoji.
                        </div>
                        <button type="submit" id="submit-new-password" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </div>
        </form>
        </body>
        </html>
    `;

    export function ChangePasswordEvent() {
        $("#submit-new-password").click(function () {
            // TODO: use old password to validate with the backend later
            const oldPassword = $('#input-old-password').val();
            const newPassword = $('#input-new-password').val();

            const request = {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newPassword),
            };

            fetch(PASSWORD_URI, request)
                .then(res => {
                    console.log(res.status);
                }).catch(error => {
                console.log(error.status);
            }).finally(() => {
                CreateView("/");
            })
        });
    }
}