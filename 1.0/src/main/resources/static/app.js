function openNewTask() {
    openTask(null);
}

function closeTask() {
    document.getElementById("task").style.visibility = "hidden";
}

function completeTask(id) {
    const taskText = document.getElementById("task-"+id);
    if (!taskText) return;

    // Set line-through
    const textDecoration = taskText.style.textDecoration;
    if (textDecoration === "line-through") {
        taskText.style.textDecoration = "none";
    } else {
        taskText.style.textDecoration = "line-through"; 
    }

    // Set completed in backend
    fetch("complete/"+id, {
        method: "PUT"
    });
}

async function openTaskDetail(id) {
    
    const response = await fetch("detail/"+id);
    if (response.ok) {
        const task = await response.json();
        openTask(task);
    }
}

function openTask(task) {
    document.getElementById("task").style.visibility = "visible";

    // Clear form fields
    document.getElementById("task-name").value = task ? task.name : null;
    document.getElementById("task-description").value = task ? task.description : null;
	document.getElementById("task-dueDate").value = task ? task.dueDate : null;
    
    // If task-id element exists, remove it, otherwise, add a new one
    const taskId = document.getElementById("task-id");
    if (taskId && !task) {
        taskId.remove();
    
    } else if (!taskId && task) {
        const inputNode = document.createElement("input");
        inputNode.setAttribute("type", "hidden");
        inputNode.setAttribute("id", "task-id");
        inputNode.setAttribute("name", "id");
        inputNode.setAttribute("value", task.id);
        document.getElementById("task-form").appendChild(inputNode);
    }
	
	// Set min-date today
	const today = new Date();
	let day = today.getDate();
	if (day < 10) day = '0' + day;
	
	let month = today.getMonth() + 1;
	if (month < 10) month = '0' + month;
	
	document.getElementById("task-dueDate").min = today.getFullYear() + '-' + month + '-' + day;
}

function search() {
    const text = document.getElementById("search").value;

    window.location.href = '/?filter=search&search='+text;
}