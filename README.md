# memeShare

This is a very simple and minimalist app where users can infinitely browse through memes and also share their favourite ones. The architecture used for this app is MVVM. 
The memes are scraped from reddit and I used - https://github.com/D3vd/Meme_Api to get the memes in json format which is then deserialized via gson.
Their is a viewpager that receives the list and displays it to user.
I have also implemented a simple caching strategy, and infite scrolling.

Technologies used :
1) kotlin - programming language
2) Flows - to get data and also used in implementation of caching
3) room - makes it easier to use the sqlite database
4) viewpager2 - to display the list of memes, which the users can swipe


