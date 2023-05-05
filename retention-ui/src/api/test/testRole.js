import request from '@/utils/request'

// 查询角色测试列表
export function listTestRole(query) {
  return request({
    url: '/test/testRole/list',
    method: 'get',
    params: query
  })
}

// 查询角色测试详细
export function getTestRole(id) {
  return request({
    url: '/test/testRole/' + id,
    method: 'get'
  })
}

// 新增角色测试
export function addTestRole(data) {
  return request({
    url: '/test/testRole',
    method: 'post',
    data: data
  })
}

// 修改角色测试
export function updateTestRole(data) {
  return request({
    url: '/test/testRole',
    method: 'put',
    data: data
  })
}

// 删除角色测试
export function delTestRole(id) {
  return request({
    url: '/test/testRole/' + id,
    method: 'delete'
  })
}
