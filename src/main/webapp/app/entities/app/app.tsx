import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IApp } from 'app/shared/model/app.model';
import { getEntities } from './app.reducer';

export const App = () => {
  const dispatch = useAppDispatch();

  const location = useLocation();
  const navigate = useNavigate();

  const appList = useAppSelector(state => state.app.entities);
  const loading = useAppSelector(state => state.app.loading);

  useEffect(() => {
    dispatch(getEntities({}));
  }, []);

  const handleSyncList = () => {
    dispatch(getEntities({}));
  };

  return (
    <div>
      <h2 id="app-heading" data-cy="AppHeading">
        Apps
        <div className="d-flex justify-content-end"></div>
      </h2>
      <div className="table-responsive">
        {appList && appList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Assignee</th>
                <th>Request</th>
                <th />
              </tr>
            </thead>
            <tbody>
              {appList.map((app, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/app/${app.id}`} color="link" size="sm">
                      {app.id}
                    </Button>
                  </td>
                  <td>{app.name}</td>
                  <td>{app.assignee}</td>
                  <td>{app.request ? <Link to={`/request/${app.request.id}`}>{app.request.id}</Link> : ''}</td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && <div className="alert alert-warning">No Apps found</div>
        )}
      </div>
    </div>
  );
};

export default App;
