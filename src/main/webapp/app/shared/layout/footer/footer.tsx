import './footer.scss';

import React from 'react';

import { Col, Row } from 'reactstrap';

const Footer = () => (
  <div className="footer page-content">
    <Row>
      <Col md="12">
        <p>Copyright © 2012 - 2022 Software AG, Darmstadt, Germany and/or Software AG USA Inc., Reston, VA, USA</p>
      </Col>
    </Row>
  </div>
);

export default Footer;
