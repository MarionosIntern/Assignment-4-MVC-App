

<!DOCTYPE html>
<html lang = "en">

    <head>
        <title> Cat Gallery </title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/base-min.css">
        <link rel="stylesheet" href="style.css">
        <h1>${cat.name}</h1> 
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
        </nav>
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
    </head>
    <body>

        <h2> Welcome to the Cat Gallery. The hub for all things cat! <br>
            You can add your favorite cat to the gallery or take a look <br>
            at the cats already posted.
        </h2>

        <div class = "container" style ="margin-top: 2rem;">
            <h1>${title}</h1> 
            <a href = "/cats/create" class = "pure-button pure-button-primary">Add New Cat</a>

            <form action = "/cats/name">
                <input type = "text" name = "key" placeholder="Search By Name..">
           </form>

        <table class = "table table-striped rounded 3 overflow-hidden">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Breed</th>
                <th>Age</th>
            </tr>
            <#list catList as cat>
                <tr>
                    <td>${cat.id}</td>
                    <td><a href = "/cats/${cat.id}">${cat.name}</a></td>
                    <td>${cat.breed}</td>
                    <td>${cat.age}</td>
                </tr>
            </#list>
        </table>>

        </div>
    </body>
</html>
