const team = {
    _players: [
      {firstName: 'Colby', lastName: 'Covington', age: 31},
      {firstName: 'Kumaru', lastName: 'Usman', age: 37},
      {firstName: 'Conor', lastName: 'Mcgregor', age: 35}
    ],
    _games: [
      {opponent: 'Bellator', teamPoints: 10 , opponentPoints: 3},
      {opponent: 'GCC', teamPoints: 7 , opponentPoints: 8},
      {opponent: 'LFA', teamPoints: 4 , opponentPoints: 0}
    ],
    get players(){
      return this._players;
    },
    get games(){
      return this._games;
    },
    addPlayer(newFirstName,newLastName,newAge){
      let player = {
        firstName : newFirstName,
        lastName : newLastName,
        age : newAge,
      }
      this.players.push(player);
    },
    addGame(newOpponent, newTeamPoints, newOpponentPoints){
      let game = {
        opponent: newOpponent,
        teamPoints: newTeamPoints,
        opponentPoints: newOpponentPoints
      }
      this.games.push(game);
  
    }
  
  }
  
console.log(team._players);
team.addPlayer('Bugs', 'bunny', 76);
console.log(team._players);
console.log(team._games);
team.addGame('Titans', 100, 98);
console.log(team._games);
/*BUILDING INTERACTIVE WEBSITES
Team Stats
We want to create, retrieve, and add information about your favorite sports team. Basketball, soccer, tennis, or water polo, you pick it. 
It’s your job to create data using the JavaScript data structures at your disposal: arrays and objects.

After we create these data structures in this project, feel free to challenge yourself to gain insights from them. 
For example, you might want to get the total number of games your team has played, or the average score of all of their games.
*/