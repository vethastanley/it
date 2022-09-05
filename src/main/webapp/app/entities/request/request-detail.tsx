import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './request.reducer';

export const RequestDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const requestEntity = useAppSelector(state => state.request.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="requestDetailsHeading">Request</h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">Id</span>
          </dt>
          <dd>{requestEntity.id}</dd>
          <dt>
            <span id="applicationID">Application ID</span>
          </dt>
          <dd>{requestEntity.applicationID}</dd>
          <dt>
            <span id="name">Name</span>
          </dt>
          <dd>{requestEntity.name}</dd>
          <dt>
            <span id="doj">Doj</span>
          </dt>
          <dd>{requestEntity.doj ? <TextFormat value={requestEntity.doj} type="date" format={APP_LOCAL_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="role">Role</span>
          </dt>
          <dd>{requestEntity.role}</dd>
          <dt>
            <span id="team">Team</span>
          </dt>
          <dd>{requestEntity.team}</dd>
          <dt>
            <span id="manager">Manager</span>
          </dt>
          <dd>{requestEntity.manager}</dd>
          <dt>
            <span id="org">Org</span>
          </dt>
          <dd>{requestEntity.org}</dd>
          <dt>
            <span id="status">Status</span>
          </dt>
          <dd>{requestEntity.status}</dd>
        </dl>
        <Button tag={Link} to="/request" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/request/${requestEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

export default RequestDetail;
