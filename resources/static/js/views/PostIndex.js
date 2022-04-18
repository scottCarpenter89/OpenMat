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
                        <h3 id="title-${post.id}">${post.title}</h3>
                        <p id="content-${post.id}">${post.content}</p>
                        <button type="button" class="btn edit-btn btn-primary mb-3" data-id="${post.id}">Edit</button>
                        <button type="button" class="btn delete-btn btn-primary mb-3" data-id="${post.id}">Delete</button>`)
        .join('')}
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
                 
                </div>
            </main>
    `;
}


export function PostsEvent() {
// TODO: create post event listeners function
    postEventListener();
// // TODO: create edit event listener function
    editEventListener()
// // TODO: create delete event listener function
    deleteEventLister();
}

function postEventListener() {
    $('#post-btn').click(function () {
        const title = $("#add-post-title").val();
        const content = $("#add-post-content").val();
        const newPost = {
            title,
            content
        }

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

function editEventListener() {
    $('.edit-btn').click(function () {
        const id = $(this).data("id");
        const title = $("#title-" + id).text();
        const content = $("#content-" + id).text();

        const editPost = {
            title,
            content
        };

        const request = {
            method: 'PUT',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(editPost),
        };

        fetch(`${POST_URI}/${id}`, request)
            .then(res => {
                console.log(res.status)
            }).catch(error => {
            console.log(error)
        }).finally(() => {
            createView("/posts");
        });
    });
}

function deleteEventLister() {
$('.delete-btn').click(function () {
    const id = $(this).data("id");

    const request = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    };

    fetch(`${POST_URI}/${id}`, request)
        .then(res => {
            console.log(res.status);
        }).catch(error => {
        console.log(error);
    }).finally(() => {
        createView("/posts");
    });
});
}