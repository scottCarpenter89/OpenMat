export default function Navbar(props) {
    // language=html
    return `
        <nav class="navbar navbar-expand-lg navbar-light bg-light mb-3">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Open-Mat</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a href="/" class="nav-link active" aria-current="page" data-link>Home</a>
                        <a href="/about" class="nav-link" data-link>About</a>
                        <a href="/posts" class="nav-link" data-link>Posts</a>
                        <a href="/login" class="nav-link" data-link>Login</a>
                        <a href="/register" class="nav-link" data-link>Register</a>
                        <a href="/users" class="nav-link" data-link>User Info</a>
                    </div>
                </div>
            </div>
        </nav>
    `;
}