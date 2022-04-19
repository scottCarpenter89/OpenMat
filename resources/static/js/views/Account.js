"use strict";


import CreateView from "../createView.js";

export default function Account(props) {
    //language=html
    return `
        <!DOCTYPE html>
        <html>
        <head>
            <meta charset="UTF-8"/>
            <!--            <title>Account Information</title> -->
        </head>
        <body>
        <div >
            <h3>Change Password</h3>
            <form id="change-password">
                <div class="mb-3">
                    <label for="input-email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="input-email" value="${props.account.email}"
                           placeholder="Input your email">
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
                            <button type="submit" id="submit-new-password" class="btn btn-primary" data-id="${props.account.id}">Submit</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        </body>
        </html>
    `;
}

export function AccountEvent() {
    changePasswordEventListener();
}

function changePasswordEventListener() {
    $("#submit-new-password").click(function () {
        const id = $(this).data("id");
        const email = $('#input-email').val();
        const oldPassword = $('#input-old-password').val();
        const newPassword = $('#input-new-password').val();

        const request = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            }
        };

        fetch(`http://localhost:8080/api/account/${id}/email?email=${email}&password?oldPassword=${oldPassword}&password?newPassword=${newPassword}`, request)
            .then(res => {
                console.log(res.status);
            }).catch(error => {
            console.log(error.status);
        }).finally(() => {
            CreateView("/");
        })
    });
}