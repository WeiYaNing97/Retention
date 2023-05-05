import request from '@/utils/request'

// 查询权限测试列表
export function listTestPermission(query) {
  return request({
    url: '/test/testPermission/list',
    method: 'get',
    params: query
  })
}

// 查询权限测试详细
export function getTestPermission(id) {
  return request({
    url: '/test/testPermission/' + id,
    method: 'get'
  })
}

// 新增权限测试
export function addTestPermission(data) {
  return request({
    url: '/test/testPermission',
    method: 'post',
    data: data
  })
}

// 修改权限测试
export function updateTestPermission(data) {
  return request({
    url: '/test/testPermission',
    method: 'put',
    data: data
  })
}

// 删除权限测试
export function delTestPermission(id) {
  return request({
    url: '/test/testPermission/' + id,
    method: 'delete'
  })
}
