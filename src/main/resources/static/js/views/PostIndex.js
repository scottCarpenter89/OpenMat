import createView from "../createView.js";

const POST_URI = "http://localhost:8080/api/posts";
// <span style="float: right" id="author-${post.id}">Author: ${post.author.username}</span>
export default function PostIndex(props) {
    // language=html;
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
            <main>
            <h3>Posts</h3>
                <div id="posts-container">
                    ${props.posts.map(post => {
                        return `
                            <div class="card">
                                <h4 class="card-header">
                                    <span id="title-${post.id}">${post.title}</span>
                                    
                                </h4>
                                <div class="card-body">
                                    <p id="content-${post.id}" class="card-text">${post.content}</p>
                                </div>
                                <div class="card-footer text muted">
<!--                                TODO: need to do categories here-->


                                    <button type="button" class="btn edit-btn btn-primary mb-3" data-id="${post.id}">Edit</button>
                                    <button type="button" class="btn delete-btn btn-primary mb-3" data-id="${post.id}">Delete</button>
                                </div>
                           </div>
                    `}).join('')} 
                </div>
                <hr>
                <h3>Add a Post</h3>
                <form id="add-post-form">
                    <div class="mb-3">
                        <input type="text" class="form-control" id="add-post-title" placeholder="Post title">
                    </div>
                    <div class="mb-3">
                        <textarea class="form-control" id="add-post-content" rows="3" placeholder="Post content"></textarea>
                    </div>
                    <button type="submit" id="post-btn" class="btn btn-primary mb-3">Post</button>
                </form>
            </main>
    `;
}


export function PostEvent() {
    postEventListener();
    editEventListener();
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

        // we use id to know if this is add or edit
        const id = $("#add-post-id").val();

        // make the request
        const request = {};
        let uriExtra = "";
        if(id > 0) {
            // newPost.id = id; // don't need this for a put
            request.method = "PUT";
            uriExtra = `/${id}`;
            console.log("Ready to update this post:");
        } else {
            // newPost.id = 99999; // this doesn't need to be there
            request.method = "POST";
            console.log("Ready to add this post:");
        }
        request.headers = {
            'Content-Type': 'application/json'
        };
        request.body = JSON.stringify(newPost);

        fetch(`${POST_URI}${uriExtra}`, request)
            .then(res => {
                console.log(res.status);
            }).catch(error => {
            console.log(error);
        }).finally(() => {
            createView("/posts");
        });
    });
}

/* TODO: Clicking the edit button works and fulfills a 200 status, but I cannot change the content
        Maybe display a modal on click that prefills the data into the fields.
 */
function editEventListener() {
    $('.edit-btn').click(function () {
        const id = $(this).data("id");

// get the title and content associated with the blog post
        const oldTitle = $(`#title-${id}`).html();
        const oldContent = $(`#content-${id}`).text();
        $('#add-post-title').val(oldTitle);
        $('#add-post-content').val(oldContent)
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