import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import {} from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './app.reducer';

export const AppDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const appEntity = useAppSelector(state => state.app.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="appDetailsHeading">App</h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">Id</span>
          </dt>
          <dd>{appEntity.id}</dd>
          <dt>
            <span id="name">Name</span>
          </dt>
          <dd>{appEntity.name}</dd>
          <dt>
            <span id="assignee">Assignee</span>
          </dt>
          <dd>{appEntity.assignee}</dd>
          <dt>Request</dt>
          <dd>{appEntity.request ? appEntity.request.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/app" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/app/${appEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

export default AppDetail;
