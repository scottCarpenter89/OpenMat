"use strict";

export function getNotificationElement() {
    return `<div id="notification-box" class=""></div>`
}

export function showNotification(message, messageType) {
    const notifyBox = $('#notification-box');
    notifyBox.addClass("alert alert-" + messageType);
    notifyBox.text(message);
    notifyBox.slideDown(100).delay(3000).slideUp(200);
}