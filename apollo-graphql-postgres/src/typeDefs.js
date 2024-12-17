import { gql } from 'apollo-server';

const typeDefs = gql`
  type Client {
    id: ID!
    nom: String
    prenom: String
    email: String
    telephone: String
  }

  type Chambre {
    id: ID!
    type: String
    prix: Float
    disponible: Boolean
  }

  type Reservation {
    id: ID!
    dateDebut: String
    dateFin: String
    preferences: String
    client: Client
    chambre: Chambre
  }


  input ReservationRequest {
    clientId: ID
    chambreId: ID
    dateDebut: String
    dateFin: String
    preferences: String
  }

  input ChambreRequest {
    type: String
    prix: Float
    disponible: Boolean
  }

  input ClientRequest {
    nom: String!
    prenom: String
    email: String
    telephone: String
  }


  type Query {
    getClients: [Client]
    getChambres: [Chambre]
    getReservations: [Reservation]
    getReservation(id: ID!): Reservation
  }

  type Mutation {
    deleteClient(id:ID!):Boolean
    creerClient(client: ClientRequest): Client
    creerChambre(chambre: ChambreRequest): Chambre
    deleteChambre(id:ID!):Boolean
    creerReservation(reservation: ReservationRequest): Reservation
    deleteReservation(id:ID!):Boolean
    updateReservation(id:ID!,newReservation:ReservationRequest):Reservation
  }
`;

export default typeDefs;
