export default function Login(props) {
    // language=html
    return `
        <!DOCTYPE html>
            <html lang="en">
                <head>
                    <meta charset="UTF-8"/>
                    <title>Log In</title>
                </head>
                <body>
                    <h1>Log In</h1>
                    <form id="login-form">
                        <label for="email-login">Username</label>
                        <input id="email-login" name="email" type="email"/>
                        <label for="password">Password</label>
                        <input id="password" name="password" type="password"/>
                        <input id="login-btn" type="submit" value="Log In"/>
                    </form>
                </body>
            </html>
    `;
}


