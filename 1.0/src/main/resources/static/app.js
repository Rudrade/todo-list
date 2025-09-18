function openNewTask() {
    document.getElementById("task").style.visibility = "visible";

    // Clear form fields
    document.getElementById("task-name").value = null;
    document.getElementById("task-description").value = null;
    document.getElementById("task-id").value = null;
}

function closeTask() {
    document.getElementById("task").style.visibility = "hidden";
}