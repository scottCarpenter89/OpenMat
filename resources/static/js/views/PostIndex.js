import createView from "../createView.js";

const POST_URI = "http://localhost:8080/api/posts";

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
                        <input type="text" class="form-control" id="add-post-title" placeholder="Add a title">
                    </div>
                    <div class="mb-3">
                        <label for="add-post-content" class="form-label">Content</label>
                        <textarea class="form-control" id="add-post-content" rows="3" placeholder="Add content"></textarea>
                    </div>
                    <button type="button" id="post-btn" class="btn btn-primary mb-3">Post</button>
                    <button type="button" id="edit-btn" class="btn btn-primary mb-3" dataid="1">Edit</button>
                    <button type="button" id="delete-btn "class="btn btn-primary mb-3" dataid="2">Delete</button>
                </div>
            </main>
    `;
}


export function PostsEvent() {
// TODO: create post event listeners function
    createPostEventListener();
// // TODO: create edit event listener function
//     createEditEventListener()
// // TODO: create delete event listener function
//     createDeleteEventLister();
}

function createPostEventListener() {
    console.log("adding a post listener");
    $('#post-btn').click(function () {
        const title = $("#add-post-title").val();
        const content = $("#add-post-content").val();
        const newPost = {
            title,
            content
        }
        console.log('ready to add new post');
        console.log(newPost);

        const request = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newPost),
        };

        fetch(POST_URI, request)
            .then(res => {
                console.log(res.status);
            }).catch(error => {
            console.log(error);
        }).finally(() => {
            createView("/posts")
        });
    });
}

function createEditEventListener() {
    $('#edit-btn').click(function () {

    });
}

function createDeleteEventLister() {

}