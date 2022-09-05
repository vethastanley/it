import { IRequest } from 'app/shared/model/request.model';

export interface IApp {
  id?: string;
  name?: string;
  assignee?: string;
  request?: IRequest;
}

export const defaultValue: Readonly<IApp> = {};
