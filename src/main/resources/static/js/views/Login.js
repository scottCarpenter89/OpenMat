export default function Login(props) {
    // language=html
    return `
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8"/>
            <title>LOG IN</title>
        </head>
        <body>
        <div class="container" id="login-container">
            <h1>Login</h1>
            <div class="row">
                <div class="card container-fluid">
                    <div class="card-body">
                        <form id="login-form">
                            <div class="mb-3">
                                <label for="username" class="form-label">Email address</label>
                                <input type="email" class="form-control" id="username" name="username"
                                       placeholder="name@example.com">
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password">
                            </div>
                    </div>
                    <div class="card-footer w-100" id="login-footer">
                        <input class="btn btn-primary" id="login-btn" type="submit" value="LOG IN"/>
                    </div>
                    </form>
                </div>
            </div>
        </div>
        </body>
        </html>
    `;
}



