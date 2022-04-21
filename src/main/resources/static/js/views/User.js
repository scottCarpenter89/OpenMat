import CreateView from "../createView.js";

const USER_URI = "http://localhost:8080/api/users";

export default function UserIndex(props) {
    //language=html
    return `
        <!DOCTYPE html>
            <html lang="en">
                <header>
                    <meta charset="UTF-8"/>
                    <title>Account Information</title>
                </header>
                <main>
                    <div id="change-password-container">
                        <h3>Change Password</h3>
                        <form id="change-password">
                            <div class="mb-3">
                                <label for="input-email" class="form-label">Email</label>
                                <input disabled type="email" name="email" class="form-control" id="input-email" value="${props.users.email}"
                                       placeholder="Input your email">
                                <div class="mb-3">
                                    <label for="input-old-password" class="form-label">Old Password</label>
                                    <input disabled type="password" class="form-control" id="input-old-password" name="old-password"
                                           placeholder="Input your old password">
                                    <div class="mb-3">
                                        <label for="input-new-password" class="form-label">Password</label>
                                        <input type="password" id="input-new-password" class="form-control" name="new-password"
                                               aria-describedby="passwordHelpBlock">
                                        <div id="passwordHelpBlock" class="form-text">
                                            Your password must be 8-20 characters long, contain letters and numbers, and must
                                            not contain spaces, special characters, or emoji.
                                        </div>
                                        <button type="submit" id="change-password-btn" class="btn btn-primary"
                                                data-id="${props.users.id}">Submit
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
        
                    <hr> <!--This is where all posts authored by the user will be-->
                    
                    <div class="my-post-container">
                        <h3>My Posts</h3>
                        ${props.users.posts.map(post => {
                            return `
                        <div class="card">
                           <div class="card-header">
                                <h5 id="title-${post.id}">${post.title}</h5>
                           </div>
                           
                           <div class="card-body">
                                <p id="content-${post.id}">${post.content}</p>
                           </div>
                        </div>
                         `}).join('')};
                    </div>
                </main>
            </html>
    `;
}

export function UserEvents() {
    changePasswordEventListener();
}

function changePasswordEventListener() {
    $("#change-password-btn").click(function () {
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

        fetch(`${USER_URI}/${id}/updatePassword?email=${email}&oldPassword=${oldPassword}&newPassword=${newPassword}`, request)
            .then(res => {
                console.log(res.status);
            }).catch(error => {
            console.log(error.status);
        }).finally(() => {
            CreateView("/users");
        });
    });
}

