import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import App from './app';
import AppDetail from './app-detail';
import AppUpdate from './app-update';
import AppDeleteDialog from './app-delete-dialog';

const AppRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<App />} />
    <Route path="new" element={<AppUpdate />} />
    <Route path=":id">
      <Route index element={<AppDetail />} />
      <Route path="edit" element={<AppUpdate />} />
      <Route path="delete" element={<AppDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default AppRoutes;
