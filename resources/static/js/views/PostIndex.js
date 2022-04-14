// TODO: add bootstrap to add pretty
export default function PostIndex(props) {
    // language=html;
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <div class="container-fluid">
            <main>

                <div id="posts-container">
                    ${props.posts.map(post => `<h3>${post.title}</h3>`).join('')}
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
                </div>
            </main>
        </div>
    `;
}



export function PostEvent() {
// TODO: create post event listeners function
    createPostEventListener();
// TODO: create edit event listener function
    createEditEventListener()
// TODO: create delete event listener function
    createDeleteEventLister();
}

function createPostEventListener() {
$('#post-btn').click(function (){
    const title = $("#add-post-title").val();
    const content = $("#add-post-content").val();
    const post = {
        title,
        content
    }
    console.log(post);
});

}