# ToPlayList


-> Have you ever had so many games in your steam library that you just can't seem to know wich games you haven't played and wich ones you have? Well, this api means to solve this problem, it provides a simple way to organize the games you have played and the games you haven't!


# Supported http methods


-> GET, POST, PUT and DELETE are the supported http methods


# Suported content types


-> JSON is the only supported content type by now, maybe i'll add xml in the future... who knows :smile_cat:


# How to use


1 - Make a post request with your username and password in the request body to: https://to-play-list.onrender.com/user/register


2 - If the response code returned was 200 this means that you are now registered on the api and can use the other http methods with the username and password provided on the previous request


3 - Access one of the endpoints below and have fun organizing your game library :smiley_cat:



# ENDPOINTS



GET: https://to-play-list.onrender.com/developer


GET: https://to-play-list.onrender.com/game


GET: https://to-play-list.onrender.com/publisher


GET: https://to-play-list.onrender.com/developer/{id}


GET: https://to-play-list.onrender.com/game/{id}


GET: https://to-play-list.onrender.com/publisher/{id}


POST: https://to-play-list.onrender.com/developer


POST: https://to-play-list.onrender.com/publisher


POST: https://to-play-list.onrender.com/game/dev/{developerId}/publisher/{publisherId}


PUT: https://to-play-list.onrender.com/developer/{id}


PUT: https://to-play-list.onrender.com/publisher/{id}


PUT: https://to-play-list.onrender.com/game/{gameId}/dev/{developerId}/publisher/{publisherId}


DELETE: https://to-play-list.onrender.com/developer/{id}


DELETE: https://to-play-list.onrender.com/publisher/{id}


DELETE: https://to-play-list.onrender.com/game/{id}



-> Remember that you only need to provide the name of the publisher and the name of the developer in their respective endpoints and also that you need to provide the name of the game and it's status in the POST and PUT requests for game.

# Supported status types for game

0 - NOT_PLAYED


1 - PLAYING


2 - FINISHED


3 - COMPLETED

-> WARNING: make sure to use the status type numbers (0,1,2,3) when you make the requests, since it is an enum
