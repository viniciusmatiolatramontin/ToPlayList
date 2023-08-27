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

-> Also, the endpoints might not be working because render (the hosting service i'm using) only let's the application run for 15 minutes before shutting down, if the application is down and you wan't to see how it works there are some gifs of me testing it right below :smiley_cat:

# Authentication

![AUTH](https://github.com/viniciusmatiolatramontin/ToPlayList/assets/77888037/a4096b4c-b82a-465d-86cb-b3636abf0046)

# POST methods

![POST 1](https://github.com/viniciusmatiolatramontin/ToPlayList/assets/77888037/08249f56-0891-4a96-bd38-4cf55c346691)
![POST 2](https://github.com/viniciusmatiolatramontin/ToPlayList/assets/77888037/2a92631c-e9b8-4502-aff1-bc7d960d1a8d)

# GET methods

![GET 1](https://github.com/viniciusmatiolatramontin/ToPlayList/assets/77888037/e0318bc7-4257-48f0-9727-010f83106aa8)
![GET 2](https://github.com/viniciusmatiolatramontin/ToPlayList/assets/77888037/9c7f9834-44e3-4309-8bd1-b3543e36a77b)

# PUT methods and example of exception treatment

![PUT 1](https://github.com/viniciusmatiolatramontin/ToPlayList/assets/77888037/c44b4b2b-479f-4fa6-9e54-967f0264ecfe)
![PUT 2](https://github.com/viniciusmatiolatramontin/ToPlayList/assets/77888037/5620cae8-a263-4f4c-a2b9-89184fdc6c93)

# DELETE methods and more exception treatment examples

![DELETE 1](https://github.com/viniciusmatiolatramontin/ToPlayList/assets/77888037/11b78ad8-75c8-4ba1-ae15-e8b7dfd27dcd)

# Testing the division of games, developers and publishers by each user

![AUTH 2nd user](https://github.com/viniciusmatiolatramontin/ToPlayList/assets/77888037/baf7821e-d37c-4c76-a6a5-0d7a1ad42587)

# Supported status types for game

0 - NOT_PLAYED


1 - PLAYING


2 - FINISHED


3 - COMPLETED

-> WARNING: make sure to use the status type numbers (0,1,2,3) when you make the requests, since it is an enum
