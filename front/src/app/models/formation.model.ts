import Session from "./session.model";
import Theme from "./theme.model";


export default interface Formation extends Theme, Session {
  id: number;
  intitule: string;
  publicConcerne: string;
  description: string;
  objectif: string;
  prerequis: string;
  duree: string;
  estIntra: boolean;
  distanciel: boolean;
  image: string;
  reference : string;
  tarif: number;
  theme: Theme;
  session : Session;
}
