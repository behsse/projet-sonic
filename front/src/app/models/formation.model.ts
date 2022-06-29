import Theme from "./theme.model";

export default interface Formation extends Theme {
  id: number;
  intitule: string;
  publicConcerne: string;
  description: string;
  objectif: string;
  prerequis: string;
  duree: string;
  estIntra: boolean;
  estDistanciel: boolean;
  image: string;
  theme: Theme;
}
