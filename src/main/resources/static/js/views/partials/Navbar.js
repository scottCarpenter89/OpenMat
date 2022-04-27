import {isLoggedIn} from "../Logout.js";

export default function Navbar(props) {
    let html = `
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <img class="navbar-brand" src="../../../img/logo1.png">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a href="/" class="nav-link active" aria-current="page" data-link>Home</a>
                        <a href="/about" class="nav-link" data-link>About</a>`;

    if (isLoggedIn()) {
       html = html + `
                        <a href="/posts" class="nav-link" data-link>Posts</a>
                        <a href="/users" class="nav-link" data-link>User Info</a>
                        <a href="/logout" class="nav-link" data-link>Logout</a>
       `;
    } else {
        html = html + `
                        <a href="/register" class="nav-link" data-link>Register</a>
                        <a href="/login" class="nav-link" data-link>Login</a>
        `;
    }
    html = html + `</div>
                </div>
            </div>
        </nav>`;
    return html;
}


