<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>博客</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>

        #big_cont {
            display: flex;
        }

        #head_cont {
            background-color: #333333;
            color: #ffcc00;
            padding: 20px;
            text-align: center;
            width: 250px; /* Set the width of the navigation bar */
        }

        #map {
            display: flex;
            flex-direction: column;
        }

        #map ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        #map a {
            text-decoration: none;
            color: #fff;
            font-weight: bold;
            font-size: 16px;
            transition: color 0.3s ease;
            padding: 10px; /* Add padding to each link for better readability */
            display: block; /* Make each link a block element for full width */
        }

        #map a:hover {
            color: #ffcc00;
        }

        .user-info {
            display: flex;
            flex-direction: column;
            align-items: flex-end;
            margin-top: auto; /* Push user-info to the bottom */
        }

        .logout-link {
            color: #ffcc00;
            font-weight: bold;
            text-decoration: none;
            font-size: 16px;
            margin-top: 5px;
            transition: color 0.3s ease;
        }

        .logout-link:hover {
            color: #fff;
        }
    </style>
</head>
<body>
    
        
            <h1>个人空间</h1>
            <div id="map">
                <ul>
                    
                    <li><a href="Article">类型管理</a></li>
                    <li><a href="">文章管理</a></li>
              
                    
                    
                </ul>
            </div>
       
</body>
</html>

