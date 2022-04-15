// TODO: add bootstrap to add pretty
export default function PostIndex(props) {
    // language=html;
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
            <main>
                <div id="posts-container">
                    ${props.posts.map(post => `
                        <h3>${post.title}</h3>
                        <p>${post.content}</p>`).join('')}
                </div>
                <div id="add-post-container">
                    <div class="mb-3">
                        <label for="add-post-title" class="form-label">Title</label>
                        <input class="form-control" id="add-post-title" placeholder="Add title">
                    </div>
                    <div class="mb-3">
                        <label for="add-post-content" class="form-label">Content</label>
                        <textarea class="form-control" id="add-post-content" rows="3"></textarea>
                    </div>
                    <button type="button" class="post-btn btn-outline-primary">Post</button>
                    <button type="button" class="edit-btn btn-outline-primary" dataid="1">Edit</button>
                    <button type="button" class="delete-btn btn-outline-primary" dataid="2">Delete</button>
                </div>
            </main>`;
}


export function PostsEvent() {
// TODO: create post event listeners function
    createPostEventListener();
// TODO: create edit event listener function
    createEditEventListener()
// TODO: create delete event listener function
    createDeleteEventLister();
}

function createPostEventListener() {
    $('#post-btn').click(function () {
        const title = $("#add-post-title").val();
        const content = $("#add-post-content").val();
        const post = {
            title,
            content
        }
        console.log(post);
    });

}

function createEditEventListener() {
    $('#edit-btn').click(function () {

    });
}

function createDeleteEventLister() {

}