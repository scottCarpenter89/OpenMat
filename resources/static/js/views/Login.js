export default function Login(props) {
    // language=html;
    return `<!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8"/>
        <title>Log In</title>
    </head>
    <body>
    <h1>Log In</h1>

    <form id="login-form">
        <label for="username">Username</label>
        <input id="username" name="username" type="text"/>
        <label for="password">Password</label>
        <input id="password" name="password" type="password"/>
        <input id="login-btn" type="submit" value="Log In"/>
    </form>
    </body>
    </html>`;

}



// export function LoginEvent() {
// //TODO: create an event listener that takes the fields and sends them to the backend to verify the credentials
//     loginEventListener();
// }
//
// function loginEventListener() {
// $('#login-btn').click(function () {
//     const username =
// });
// }