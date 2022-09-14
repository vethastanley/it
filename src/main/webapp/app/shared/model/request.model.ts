import { IApp } from 'app/shared/model/app.model';
import { Status } from 'app/shared/model/enumerations/status.model';

export interface IRequest {
  id?: string;
  applicationID?: string;
  name?: string;
  doj?: number;
  role?: string;
  team?: string;
  manager?: string;
  org?: string;
  status?: Status | null;
  apps?: IApp[] | null;
}

export const defaultValue: Readonly<IRequest> = {};
