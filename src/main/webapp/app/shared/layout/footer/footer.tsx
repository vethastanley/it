import './footer.scss';

import React from 'react';

import { Col, Row } from 'reactstrap';

const Footer = () => (
  <div className="footer page-content">
    <Row>
      <Col md="12">
        <p>Copyright © 2012 - 2022 United Motor Group, Darmstadt, Germany and/or United Motor Group USA Inc., Reston, VA, USA</p>
      </Col>
    </Row>
  </div>
);

export default Footer;
