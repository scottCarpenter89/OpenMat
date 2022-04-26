import createView from "../createView.js";

const getAccessToken = window.localStorage.getItem('access_token');
const getRefreshToken = window.localStorage.getItem('refresh_token');

export default function Logout(props) {
    console.log("Logging out...");

}

export function LogoutEvent() {
    console.log("Calling Logout Events");
    if (isLoggedIn()) {
        window.localStorage.removeItem('access_token');
        window.localStorage.removeItem('refresh_token');
    }
    return createView("/");
}

export function isLoggedIn() {
    if (getAccessToken && getRefreshToken) {
        return true;
    }
}
