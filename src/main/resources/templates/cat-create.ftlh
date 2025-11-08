
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>  Add New Animal </title>
        <h1>Animal Gallery</h1>
        
        <link rel="stylesheet" href="style.css">
       <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
        <div class = "pure-menu pure-menu-horizontal">
            <ul class = "pure-menu-list">
                <li class = "pure-menu-item">
                    <a href = "index.html" class = "pure-menu-link">Home</a>
                </li>
                <li class = "pure-menu-item">
                    <a href = "details.html" class = "pure-menu-link">Details</a>
                </li>
                <li class = "pure-menu-item">
                    <a href = "about.html" class = "pure-menu-link">About</a>
                </li>
                <li class = "pure-menu-item">
                    <a href = "new-animal-form.html" class = "pure-menu-link">New Animal Form</a>
                </li>
            </ul>
        </div>
        <h2>This Gallery could always use your help. Thank you!</h2>
    </head>

    <body>
        <h3>Add a New Animal</h3>

        <form>
            <label>Name: <input type="text" name = "name" required></label> <br>
            <label>Type: <input type="text" name = "type" required></label> <br>
            <label>Age: <input type="number" name = "age" required></label> <br>
            <label>Species: <input type="text" name = "species" required></label> <br>
            <button type = "submit">Submit</button>
        </form>
    </body>

</html>