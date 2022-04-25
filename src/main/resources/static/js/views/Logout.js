import createView from "../createView.js";

export default function Logout(props) {
    console.log("Logging out...");
    return ``;
}

export function LogoutEvent() {
    console.log("Calling Logout Events");
    window.localStorage.removeItem("access_token");
    window.localStorage.removeItem("refresh_token");
    createView("/login");
}