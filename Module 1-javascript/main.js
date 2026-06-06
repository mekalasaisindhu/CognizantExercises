// ===================================================
// Question 1
// ===================================================

console.log("Welcome to the Community Portal");

window.onload = function () {
    alert("Page has been loaded successfully!");
};

// ===================================================
// Question 2
// ===================================================

const eventName = "Music Festival";
const eventDate = "15 June 2026";
let availableSeats = 50;

console.log(
`Event: ${eventName} | Date: ${eventDate} | Seats: ${availableSeats}`
);

availableSeats--;

console.log(
`Remaining Seats: ${availableSeats}`
);

// ===================================================
// Question 3,4,5,6
// ===================================================

function Event(name, category, date, seats) {
    this.name = name;
    this.category = category;
    this.date = date;
    this.seats = seats;
}

Event.prototype.checkAvailability = function () {
    return this.seats > 0;
};

const events = [

    new Event(
        "Music Festival",
        "Music",
        "2026-07-15",
        50
    ),

    new Event(
        "Baking Workshop",
        "Workshop",
        "2026-08-10",
        25
    ),

    new Event(
        "Art Exhibition",
        "Art",
        "2026-09-01",
        15
    )
];

// Object.entries()

Object.entries(events[0]).forEach(([k,v])=>{
    console.log(k,v);
});

// addEvent()

function addEvent(
    name,
    category,
    date,
    seats
){
    events.push(
        new Event(
            name,
            category,
            date,
            seats
        )
    );
}

// registerUser()

function registerUser(eventName){

    try{

        const event = events.find(
            e => e.name === eventName
        );

        if(!event){
            throw new Error("Event not found");
        }

        if(event.seats <= 0){
            throw new Error("No seats available");
        }

        event.seats--;

        renderEvents(events);

    }
    catch(error){
        console.log(error.message);
    }
}

// filterEventsByCategory()

function filterEventsByCategory(category){

    return events.filter(
        e => e.category === category
    );
}

// Closure

function registrationTracker(){

    let total = 0;

    return function(){

        total++;

        return total;
    };
}

const musicCounter =
registrationTracker();

console.log(musicCounter());
console.log(musicCounter());

// Higher Order Function

function searchEvents(callback){

    return events.filter(callback);
}

// Question 6

addEvent(
    "Dance Night",
    "Music",
    "2026-10-01",
    20
);

const musicEvents =
events.filter(
    e => e.category === "Music"
);

console.log(musicEvents);

const cards =
events.map(
    e => `Workshop on ${e.name}`
);

console.log(cards);

// ===================================================
// Question 7 & 8
// ===================================================

const eventContainer =
document.querySelector("#eventContainer");

function renderEvents(eventList){

    eventContainer.innerHTML = "";

    eventList.forEach((event,index)=>{

        const card =
        document.createElement("div");

        card.className =
        "event-card";

        card.innerHTML = `
            <h3>${event.name}</h3>
            <p>${event.category}</p>
            <p>Seats: ${event.seats}</p>

            <button
            onclick="registerUser('${event.name}')">
            Register
            </button>

            <button
            onclick="cancelRegistration(${index})">
            Cancel
            </button>
        `;

        eventContainer.appendChild(card);
    });
}

function cancelRegistration(index){

    events[index].seats++;

    renderEvents(events);
}

renderEvents(events);

// onchange

document
.getElementById("categoryFilter")
.onchange = function(){

    const category = this.value;

    if(category === "All"){

        renderEvents(events);

    }else{

        renderEvents(
            filterEventsByCategory(category)
        );
    }
};

// keydown

document
.getElementById("searchBox")
.addEventListener("keydown",function(){

    setTimeout(()=>{

        const text =
        this.value.toLowerCase();

        const result =
        searchEvents(
            e =>
            e.name.toLowerCase()
            .includes(text)
        );

        renderEvents(result);

    },100);

});

// ===================================================
// Question 9
// ===================================================

// Promise Version

fetch(
"https://jsonplaceholder.typicode.com/posts"
)
.then(response=>response.json())
.then(data=>console.log(data))
.catch(error=>console.log(error));

// Async/Await Version

async function loadData(){

    try{

        document
        .getElementById("loading")
        .innerText = "Loading...";

        const response =
        await fetch(
        "https://jsonplaceholder.typicode.com/posts"
        );

        const data =
        await response.json();

        console.log(data);

        document
        .getElementById("loading")
        .innerText = "";

    }
    catch(error){

        console.log(error);
    }
}

loadData();

// ===================================================
// Question 10
// ===================================================

function greetUser(
    name = "Guest"
){
    console.log(name);
}

const {
    name,
    category
} = events[0];

console.log(name,category);

const clonedEvents =
[...events];

// ===================================================
// Question 11
// ===================================================

document
.getElementById("registerForm")
.addEventListener(
"submit",
function(event){

    event.preventDefault();

    const username =
    this.elements.username.value;

    const email =
    this.elements.email.value;

    const selectedEvent =
    this.elements.selectedEvent.value;

    if(
        username === "" ||
        email === ""
    ){

        document
        .getElementById("formError")
        .innerText =
        "All fields are required";

        return;
    }

    document
    .getElementById("formError")
    .innerText = "";

    console.log(
        username,
        email,
        selectedEvent
    );

    submitRegistration({
        username,
        email,
        selectedEvent
    });

});

// ===================================================
// Question 12
// ===================================================

function submitRegistration(data){

    console.log("Submitting form");

    setTimeout(()=>{

        fetch(
        "https://jsonplaceholder.typicode.com/posts",
        {
            method:"POST",

            headers:{
                "Content-Type":
                "application/json"
            },

            body:
            JSON.stringify(data)
        })

        .then(response=>response.json())

        .then(result=>{

            console.log(result);

            alert(
            "Registration Successful"
            );

        })

        .catch(error=>{

            console.log(error);

            alert(
            "Registration Failed"
            );

        });

    },2000);
}

// ===================================================
// Question 13
// ===================================================

console.log(
"Use DevTools Console, Network Tab and Breakpoints"
);

// ===================================================
// Question 14
// ===================================================

$("#registerBtn").click(function(){

    console.log(
    "jQuery Register Button Clicked"
    );
});

$(".event-card").fadeIn();

setTimeout(()=>{

    $(".event-card").fadeOut();

    setTimeout(()=>{

        $(".event-card").fadeIn();

    },1000);

},3000);

